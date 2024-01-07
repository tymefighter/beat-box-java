package beatBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import beatBox.state.State;
import beatBox.state.InstrumentState;

import beatBox.musicPlayer.MusicPlayer;
import beatBox.musicPlayer.SetupException;
import beatBox.musicPlayer.PlayException;

import beatBox.gui.Gui;
import beatBox.gui.ButtonEventListener;
import beatBox.gui.ButtonEvent;
import beatBox.gui.FileButtonEvent;
import beatBox.gui.ButtonEventType;

class Controller implements ButtonEventListener {
  private MusicPlayer musicPlayer;
  private Gui gui;

  public Controller() throws SetupException {
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
        case START: {
          InstrumentState[] instrumentStates = gui.getInstrumentStates();
          musicPlayer.start(instrumentStates);

          break;
        }

        case STOP: {
          musicPlayer.stop();

          break;
        }

        case TEMPO_UP: {
          musicPlayer.tempoUp();

          break;
        }

        case TEMPO_DOWN: {
          musicPlayer.tempoDown();

          break;
        }

        case SAVE: {
          FileButtonEvent fileButtonEvent = (FileButtonEvent) buttonEvent;
          File file = fileButtonEvent.getFile();

          if(file != null) {
            InstrumentState[] instrumentStates = gui.getInstrumentStates();
            State state = new State()
              .setInstrumentStates(instrumentStates);

            StateSaver.saveState(file, state);
          }

          break;
        }

        case RESTORE: {
          musicPlayer.stop();

          FileButtonEvent fileButtonEvent = (FileButtonEvent) buttonEvent;
          File file = fileButtonEvent.getFile();

          if(file != null) {
            State state = StateSaver.restoreState(file);

            gui.setInstrumentStates(
              state.getInstrumentStates()
            );
          }

          break;
        }
      }
    } catch(PlayException playException) {
      Logger.error("PlayException occurred while handling button event");
      Logger.exception(playException);
    } catch(FileNotFoundException fileNotFoundException) {
      Logger.error("FileNotFoundException occurred while handling button event");
      Logger.exception(fileNotFoundException);
    } catch(IOException ioException) {
      Logger.error("IOException occurred while handling button event");
      Logger.exception(ioException);
    } catch(ClassNotFoundException classNotFoundException) {
      Logger.error("ClassNotFoundException occurred while handling button event");
      Logger.exception(classNotFoundException);
    }
  }
}
