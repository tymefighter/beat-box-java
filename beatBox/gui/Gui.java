package beatBox.gui;

import javax.swing.JFrame;

import java.awt.Container;
import java.awt.BorderLayout;

import beatBox.state.InstrumentState;

public class Gui {
  private static final int FRAME_WIDTH = 1280, FRAME_HEIGHT = 720;

  private JFrame frame;

  private ButtonsPanel buttonsPanel;
  private InstrumentGridInput instrumentGridInput;

  public Gui() {
    frame = new JFrame();

    frame.setDefaultCloseOperation(
      JFrame.EXIT_ON_CLOSE
    );

    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

    Container contentPane = frame.getContentPane();

    buttonsPanel = new ButtonsPanel(frame);
    contentPane.add(
      BorderLayout.EAST, 
      buttonsPanel
    );

    instrumentGridInput = new InstrumentGridInput();
    contentPane.add(
      BorderLayout.CENTER, 
      instrumentGridInput
    );

    contentPane.add(
      BorderLayout.WEST, 
      new InstrumentLabels()
    );
  }

  public void display() {
    frame.setVisible(true);
  }

  public void addButtonEventListener(ButtonEventListener buttonEventListener) {
    buttonsPanel.addButtonEventListener(buttonEventListener);
  }

  public InstrumentState[] getInstrumentStates() {
    return instrumentGridInput.getInstrumentStates();
  }

  public void setInstrumentStates(InstrumentState[] instrumentStates) {
    instrumentGridInput.setInstrumentStates(instrumentStates);
  }
}
