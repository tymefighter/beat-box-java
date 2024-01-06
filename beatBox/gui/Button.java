package beatBox.gui;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

class Button extends JButton implements ActionListener {
  private ButtonEventType type;

  private ArrayList<ButtonEventListener> buttonEventListeners;

  public Button(ButtonEventType type, String label) {
    super(label);

    buttonEventListeners = new ArrayList<ButtonEventListener>();
    this.type = type;

    addActionListener(this);
  }

  public void addButtonEventListener(ButtonEventListener buttonEventListener) {
    buttonEventListeners.add(buttonEventListener);
  }

  public void actionPerformed(ActionEvent actionEvent) {
    for(ButtonEventListener buttonEventListener : buttonEventListeners) {
      buttonEventListener.actionPerformed(
        new ButtonEvent(type)
      );
    }
  }
}
