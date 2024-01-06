package beatBox;

import beatBox.musicPlayer.SetupException;
import beatBox.musicPlayer.PlayException;

public class BeatBox {
  public static void main(String[] args) {
    try {
      new Controller()
      .start();
    } catch(SetupException setupException) {
      Logger.error("SetupException occurred while running Controller");
      Logger.exception(setupException);
    }
  }
}
