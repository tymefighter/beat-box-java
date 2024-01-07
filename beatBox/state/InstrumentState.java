package beatBox.state;

import java.io.Serializable;

public class InstrumentState implements Serializable {
  private static final long serialVersionUID = -2356169535651396583L;

  private int instrumentKey;
  private int[] beats;

  public InstrumentState(int instrumentKey, int[] beats) {
    this.instrumentKey = instrumentKey;
    this.beats = beats;
  }

  public int getInstrumentKey() {
    return instrumentKey;
  }

  public int[] getBeats() {
    return beats;
  }
}
