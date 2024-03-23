package Pages;


import Properties.AppConfig;
import lombok.Getter;

@Getter
public abstract class BasePage {
  protected String baseUrl = AppConfig.getUrl();
}