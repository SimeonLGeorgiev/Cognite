package Helpers;

public class StringReplacer {

  public static double extractPrice(String text) {
    return Double.parseDouble(text.replaceAll("[^\\d.]+", " ").trim());
  }
}