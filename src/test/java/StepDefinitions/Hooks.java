package StepDefinitions;

import Helpers.WebDriverManager;
import io.cucumber.java.AfterAll;


public class Hooks {

  @AfterAll
  public static void afterAll() {
    WebDriverManager.quitDriver();
  }
}