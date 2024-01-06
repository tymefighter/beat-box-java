package beatBox.state;

public class State {
  private InstrumentState[] instrumentStates;

  public State() {
    instrumentStates = new InstrumentState[0];
  }

  public void setInstrumentStates(InstrumentState[] instrumentStates) {
    this.instrumentStates = instrumentStates;
  }

  public InstrumentState[] getInstrumentStates() {
    return instrumentStates;
  }
}
