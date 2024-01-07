package beatBox.state;

import java.io.Serializable;

public class State implements Serializable {
  private static final long serialVersionUID = -3382188181212879900L;

  private InstrumentState[] instrumentStates;

  public State() {
    instrumentStates = new InstrumentState[0];
  }

  public State setInstrumentStates(InstrumentState[] instrumentStates) {
    this.instrumentStates = instrumentStates;

    return this;
  }

  public InstrumentState[] getInstrumentStates() {
    return instrumentStates;
  }
}
