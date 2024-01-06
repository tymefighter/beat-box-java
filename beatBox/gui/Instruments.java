package beatBox.gui;

class Instruments {
  private static final Instrument[] instruments;

  static {
    instruments = new Instrument[] {
      new Instrument("Bass Drum", 35),
      new Instrument("Closed Hi-Hat", 42),
      new Instrument("Open Hi-Hat", 46),
      new Instrument("Acoustic Snare", 38),
      new Instrument("Crash Cymbal", 49),
      new Instrument("Hand Clap", 39),
      new Instrument("High Tom", 50),
      new Instrument("Hi Bongo", 60),
      new Instrument("Maracas", 70),
      new Instrument("Whistle", 72),
      new Instrument("Low Conga", 64),
      new Instrument("Cowbell", 56),
      new Instrument("Vibraslap", 58),
      new Instrument("Low-mid Tom", 47),
      new Instrument("High Agogo", 67),
      new Instrument("Open Hi Conga", 63)
    };
  }

  public static Instrument[] getInstruments() {
    return instruments;
  }
}
