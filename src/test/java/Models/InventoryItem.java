package Models;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.By;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryItem {
  private String name;
  private double price;
  private String addToCartButton;
  private String removeButton;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InventoryItem that = (InventoryItem) o;
    return Double.compare(price, that.price) == 0 && Objects.equals(name, that.name);
  }
}
