package beatBox.gui;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import java.awt.GridLayout;

import java.util.ArrayList;

import beatBox.state.InstrumentState;

class InstrumentGridInput extends JPanel {
  private static final int ROWS = 16, COLS = 16;

  private static final int V_GAP = 1, H_GAP = 2;

  private JCheckBox[] checkBoxes;

  public InstrumentGridInput() {
    GridLayout gridLayout = new GridLayout(ROWS, COLS + 1);
    gridLayout.setVgap(V_GAP);
    gridLayout.setHgap(H_GAP);

    setLayout(gridLayout);

    checkBoxes = new JCheckBox[ROWS * COLS];

    for(int instrumentIndex = 0; instrumentIndex < ROWS; instrumentIndex++) {
      for(int beat = 0; beat < COLS; beat++) {
        int checkBoxIndex = instrumentIndex * COLS + beat;

        JCheckBox checkBox = checkBoxes[checkBoxIndex] = new JCheckBox();
        checkBox.setSelected(false);

        add(checkBox);
      }
    }
  }

  public InstrumentState[] getInstrumentStates() {
    Instrument[] instruments = Instruments.getInstruments();

    ArrayList<InstrumentState> instrumentStates = new ArrayList<InstrumentState>();

    for(int instrumentIndex = 0; instrumentIndex < ROWS; instrumentIndex++) {
      ArrayList<Integer> beats = new ArrayList<Integer>();
      int instrumentKey = instruments[instrumentIndex].getKey();
      
      for(int beat = 0; beat < COLS; beat++) {
        int checkBoxIndex = instrumentIndex * COLS + beat;
        JCheckBox checkBox = checkBoxes[checkBoxIndex];

        if(checkBox.isSelected()) {
          beats.add(beat);
        }
      }

      if(beats.size() > 0) {
        instrumentStates.add(
          new InstrumentState(
            instrumentKey,
            beats.stream().mapToInt(i -> i).toArray()
          )
        );
      }
    }

    return instrumentStates.toArray(new InstrumentState[0]);
  }

  public void setInstrumentStates(InstrumentState[] instrumentStates) {
    Instrument[] instruments = Instruments.getInstruments();

    boolean[] checkBoxStates = new boolean[checkBoxes.length];

    for(InstrumentState instrumentState : instrumentStates) {
      int instrumentKey = instrumentState.getInstrumentKey();
      int[] beats = instrumentState.getBeats();

      int instrumentIndex = 0;
      while(
        instrumentIndex < instruments.length
        && instruments[instrumentIndex].getKey() != instrumentKey
      ) {
        instrumentIndex ++;
      }

      if(instrumentIndex == instruments.length) {
        continue;
      }

      for(int beat : beats) {
        int checkBoxIndex = instrumentIndex * COLS + beat;
        checkBoxStates[checkBoxIndex] = true;
      }
    }

    for(int index = 0; index < checkBoxes.length; index ++) {
      checkBoxes[index].setSelected(checkBoxStates[index]);
    }
  }
}
