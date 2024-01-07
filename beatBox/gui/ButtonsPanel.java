package beatBox.gui;

import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.BoxLayout;

import java.util.ArrayList;

class ButtonsPanel extends Box {
  private JFrame frame;

  private ArrayList<Button> buttons;

  private void addButton(
    Button button
  ) {
    add(button);
    buttons.add(button);
  }

  private void addButton(
    ButtonEventType buttonEventType,
    String label
  ) {
    Button button = new Button(
      buttonEventType,
      label
    );

    addButton(button);
  }

  public ButtonsPanel(JFrame frame) {
    super(BoxLayout.Y_AXIS);

    this.frame = frame;

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

    addButton(
      new FileButton(
        frame,
        ButtonEventType.SAVE,
        "Save"
      )
    );

    addButton(
      new FileButton(
        frame,
        ButtonEventType.RESTORE,
        "Restore"
      )
    );
  }

  public void addButtonEventListener(ButtonEventListener buttonEventListener) {
    for(Button button : buttons) {
      button.addButtonEventListener(buttonEventListener);
    }
  }
}
