package shop;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ShoppingBasket {

    private final Map<String, Integer> items = new HashMap<>();
    private final Inventory inventory;
    private final Catalog catalog;

    public ShoppingBasket(Inventory inventory, Catalog catalog) {
        this.inventory = inventory;
        this.catalog = catalog;
    }

    public void add(String product) {
        add(product, 1);
    }

    public void add(String product, int count) {
        if (count <= 0) {
            return;
        }
        if (inventory.inStock(product)) {
            int currentCount = items.getOrDefault(product, 0);
            items.put(product, currentCount + count);
        }
    }

    public void remove(String product) {
        remove(product, 1);
    }

    public void remove(String product, int count) {
        if (count <= 0) {
            return;
        }
        if (items.containsKey(product)) {
            int currentCount = items.get(product);
            if (currentCount <= count) {
                items.remove(product);
            }
            items.put(product, currentCount);
        }
    }

    public void clear() {
        items.clear();
    }

    public Set<String> getContents() {
        return items.keySet();
    }

    public int getCount(String product) {
        return items.getOrDefault(product, 0);
    }

    public int getTotal() {
        int total = 0;
        for (Map.Entry<String, Integer> entry: items.entrySet()) {
            String product = entry.getKey();
            int price = catalog.getPrice(product);
            int count = entry.getValue();
            total += price * count;
        }
        return total;
    }
}
