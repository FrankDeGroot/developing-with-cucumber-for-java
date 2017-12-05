package shop;

import java.math.BigDecimal;
import java.util.*;

public class ShoppingBasket {
    private final Map<String, Item> items = new HashMap<>();
    private final Inventory inventory;
    private final Catalog catalog;

    public ShoppingBasket(Inventory inventory, Catalog catalog) {
        this.inventory = inventory;
        this.catalog = catalog;
    }

    public void add(String product) throws Exception {
        if (product.length() > 0) {
            if (inventory.inStock(product)) {
                if (items.containsKey(product)) {
                    items.get(product).setCount(items.get(product).getCount() + 1);
                } else {
                    items.put(product, new Item(product));
                }
            } else {
                throw new Exception("Out of stock");
            }
        } else {
            throw new Exception("Empty product");
        }
    }

    public Collection<Item> getContents() {
        return Collections.unmodifiableCollection(items.values());
    }

    public void remove(String product) {
        if (items.containsKey(product)) {
            Item item = items.get(product);
            if (item.getCount() == 1) {
                items.remove(product);
            } else {
                item.setCount(item.getCount() - 1);
            }
        }
    }

    public Item getItem(String product) {
        return items.get(product);
    }

    public BigDecimal getTotal() {
        return BigDecimal.ZERO;
    }
}
