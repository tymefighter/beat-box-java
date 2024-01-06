package beatBox.gui;

public class ButtonEvent {
  private ButtonEventType type;

  public ButtonEvent(ButtonEventType type) {
    this.type = type;
  }

  public ButtonEventType getType() {
    return type;
  }
}
