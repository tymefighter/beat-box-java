package beatBox;

import beatBox.state.State;
import beatBox.state.InstrumentState;

import beatBox.musicPlayer.MusicPlayer;
import beatBox.musicPlayer.SetupException;
import beatBox.musicPlayer.PlayException;

import beatBox.gui.Gui;
import beatBox.gui.ButtonEventListener;
import beatBox.gui.ButtonEvent;
import beatBox.gui.ButtonEventType;

class Controller implements ButtonEventListener {
  private State state;
  private MusicPlayer musicPlayer;
  private Gui gui;

  public Controller() throws SetupException {
    state = new State();
    musicPlayer = new MusicPlayer();
    gui = new Gui();

    gui.addButtonEventListener(this);
  }

  public void start() {
    gui.display();
  }

  public void actionPerformed(ButtonEvent buttonEvent) {
    try {
      switch(buttonEvent.getType()) {
        case START:
          InstrumentState[] instrumentStates = gui.getInstrumentStates();
          musicPlayer.start(instrumentStates);

          break;

        case STOP:
          musicPlayer.stop();

          break;

        case TEMPO_UP:
          musicPlayer.tempoUp();

          break;

        case TEMPO_DOWN:
          musicPlayer.tempoDown();

          break;
      }
    } catch(PlayException playException) {
      Logger.error("PlayException occurred while handling button event");
      Logger.exception(playException);
    }
  }
}
