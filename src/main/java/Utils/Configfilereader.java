package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configfilereader  {

  private static Properties properties;



  public static String getproperty(String key) {
      String path = "src/test/resources/config.properties";
      FileInputStream fs;
      if (properties == null) {
          properties = new Properties();
      {
          try {
              fs = new FileInputStream(path);
              properties.load(fs);

          } catch (IOException e) {
              e.printStackTrace();
              throw new RuntimeException(e.getMessage() + "Failed to load config.properties");
          }
      }
  }
      return properties.getProperty(key);
  }
}
