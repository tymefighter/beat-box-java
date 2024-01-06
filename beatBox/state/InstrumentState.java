package beatBox.state;

public class InstrumentState {
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
