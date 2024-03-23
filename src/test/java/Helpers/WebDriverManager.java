package Helpers;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
  private static WebDriver driver;

  public static WebDriver getInstance() {
    if (driver == null) {
      System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
      driver.manage().window().maximize();
    }
    return driver;
  }

  public static void quitDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}