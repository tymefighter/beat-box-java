package beatBox.gui;

import javax.swing.JFrame;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

import java.io.File;

class FileButton extends Button implements ActionListener {
  private JFrame frame;

  public FileButton(JFrame frame, ButtonEventType type, String label) {
    super(type, label);

    this.frame = frame;
  }

  public void actionPerformed(ActionEvent actionEvent) {
    JFileChooser fileChooser = new JFileChooser();

    switch(type) {
      case SAVE: {
        fileChooser.showSaveDialog(frame);

        break;
      }

      case RESTORE: {
        fileChooser.showOpenDialog(frame);

        break;
      }
    }


    File file = fileChooser.getSelectedFile();

    for(ButtonEventListener buttonEventListener : buttonEventListeners) {
      buttonEventListener.actionPerformed(
        new FileButtonEvent(type, file)
      );
    }
  }
}
