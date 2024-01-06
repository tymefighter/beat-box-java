package beatBox.gui;

class Instrument {
  private String name;
  private int key;

  public Instrument(String name, int key) {
    this.name = name;
    this.key = key;
  }

  public String getName() {
    return name;
  }

  public int getKey() {
    return key;
  }
}
