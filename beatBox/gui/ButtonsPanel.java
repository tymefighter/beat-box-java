package beatBox.gui;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.BoxLayout;

import java.util.ArrayList;

class ButtonsPanel extends Box {
  private ArrayList<Button> buttons;

  private void addButton(
    ButtonEventType buttonEventType,
    String label
  ) {
    Button button = new Button(
      buttonEventType,
      label
    );

    add(button);
    buttons.add(button);
  }

  public ButtonsPanel() {
    super(BoxLayout.Y_AXIS);

    buttons = new ArrayList<Button>();

    addButton(
      ButtonEventType.START,
      "Start"
    );

    addButton(
      ButtonEventType.STOP,
      "Stop"
    );

    addButton(
      ButtonEventType.TEMPO_UP,
      "Tempo Up"
    );

    addButton(
      ButtonEventType.TEMPO_DOWN,
      "Tempo Down"
    );
  }

  public void addButtonEventListener(ButtonEventListener buttonEventListener) {
    for(Button button : buttons) {
      button.addButtonEventListener(buttonEventListener);
    }
  }
}
