package beatBox.gui;

import java.io.File;

public class FileButtonEvent extends ButtonEvent {
  private File file;

  public FileButtonEvent(ButtonEventType type, File file) {
    super(type);

    this.file = file;
  }

  public File getFile() {
    return file;
  }
}
