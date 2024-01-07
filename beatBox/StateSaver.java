package beatBox;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import beatBox.state.State;

class StateSaver {
  public static void saveState(File file, State state) throws FileNotFoundException, IOException {
    ObjectOutputStream objOutStream = new ObjectOutputStream(
      new FileOutputStream(file)
    );

    objOutStream.writeObject(state);

    objOutStream.close();
  }

  public static State restoreState(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
    ObjectInputStream objOutStream = new ObjectInputStream(
      new FileInputStream(file)
    );

    State state = (State) objOutStream.readObject();

    objOutStream.close();

    return state;
  }
}
