package beatBox.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridLayout;

class InstrumentLabels extends JPanel {
  private static final int V_GAP = 2, H_GAP = 1;

  public InstrumentLabels() {
    Instrument[] instruments = Instruments.getInstruments();

    GridLayout gridLayout = new GridLayout(instruments.length, 1);
    gridLayout.setVgap(V_GAP);
    gridLayout.setHgap(H_GAP);

    setLayout(gridLayout);
    
    for(Instrument instrument : instruments) {
      add(
        new JLabel(
          instrument.getName()
        )
      );
    }
  }
}
