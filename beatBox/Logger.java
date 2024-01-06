package beatBox;

public class Logger {
  public static void info(String message) {
    System.out.println("info: " + message);
  }

  public static void error(String message) {
    System.err.println("error: " + message);
  }

  public static void exception(Exception ex) {
    error("Exception occurred: " + ex.getMessage());
    ex.printStackTrace();
  }
}
