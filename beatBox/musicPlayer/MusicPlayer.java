package beatBox.musicPlayer;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

import beatBox.Logger;

import beatBox.state.InstrumentState;

public class MusicPlayer {
  private static final int TEMPO_IN_BPM = 120;

  private static final int MIDI_CHANNEL = 1;

  private static final int LAST_BEAT = 15;

  private static final float TEMPO_UP_FACTOR = 1.03f, TEMPO_DOWN_FACTOR = .97f;

  private Sequencer sequencer;
  private Sequence sequence;

  public MusicPlayer() throws SetupException {
    try {
      sequencer = MidiSystem.getSequencer();
      sequencer.open();

      sequence = new Sequence(
        Sequence.PPQ,
        4
      );
    } catch(MidiUnavailableException midiUnavailableException) {
      Logger.error("MidiUnavailableException exception occurred while constructing MusicPlayer");
      Logger.exception(midiUnavailableException);

      throw new SetupException(
        "MidiUnavailableException: " + midiUnavailableException.getMessage()
      );
    } catch(InvalidMidiDataException invalidMidiDataException) {
      Logger.error("InvalidMidiDataException exception occurred while constructing MusicPlayer");
      Logger.exception(invalidMidiDataException);

      throw new SetupException(
        "InvalidMidiDataException: " + invalidMidiDataException.getMessage()
      );
    } 
  }

  public void stop() {
    sequencer.stop();

    Track[] tracks = sequence.getTracks();

    for(Track track : tracks) {
      sequence.deleteTrack(track);
    }
  }

  public void start(InstrumentState[] instrumentStates) throws PlayException {
    stop();

    Track track = sequence.createTrack();

    try {
      for(InstrumentState instrumentState : instrumentStates) {
        int instrumentKey = instrumentState.getInstrumentKey();
        int[] beats = instrumentState.getBeats();

        for(int beat : beats) {
          track.add(
            new MidiEvent(
              new ShortMessage(ShortMessage.NOTE_ON, MIDI_CHANNEL, instrumentKey, 100),
              beat
            )
          );

          track.add(
            new MidiEvent(
              new ShortMessage(ShortMessage.NOTE_OFF, MIDI_CHANNEL, instrumentKey, 100),
              beat + 1
            )
          );
        }
      }

      track.add(
        new MidiEvent(
          new ShortMessage(ShortMessage.PROGRAM_CHANGE, MIDI_CHANNEL, 1, 0),
          LAST_BEAT
        )
      );

      sequencer.setSequence(sequence); 
      sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
      sequencer.start();
      sequencer.setTempoInBPM(120);
    } catch(InvalidMidiDataException invalidMidiDataException) {
      Logger.error("InvalidMidiDataException exception occurred while constructing MusicPlayer");
      Logger.exception(invalidMidiDataException);

      throw new PlayException(
        "InvalidMidiDataException: " + invalidMidiDataException.getMessage()
      );
    }
  }

  public void tempoUp() {
    float tempoFactor = sequencer.getTempoFactor(); 
    sequencer.setTempoFactor((float)(tempoFactor * TEMPO_UP_FACTOR));
  }

  public void tempoDown() {
    float tempoFactor = sequencer.getTempoFactor(); 
    sequencer.setTempoFactor((float)(tempoFactor * TEMPO_DOWN_FACTOR));
  }
}
