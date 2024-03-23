package Models;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {

  private static Cart instance;
  private static ArrayList<InventoryItem> items = new ArrayList<>();
  private boolean isUsed = false;

  private Cart() {
    items = new ArrayList<>();
  }

  public static synchronized Cart getInstance() {
    if (instance == null) {
      instance = new Cart();
    }
    return instance;
  }

  public synchronized void addItem(InventoryItem item) {
    items.add(item);
  }

  public synchronized void removeItem(InventoryItem item) {
    items.remove(item);
  }

  public synchronized ArrayList<InventoryItem> getItems() {
    return items;
  }
}

