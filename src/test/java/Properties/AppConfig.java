package Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {
  private static final Properties properties;

  static {
    properties = new Properties();
    try {
      properties.load(new FileInputStream("src/test/resources/application.properties"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String getUrl() {
    return properties.getProperty("application.url");
  }
}
