package shop;

import java.util.HashSet;
import java.util.Set;

public class ShoppingBasket {

    private final Set<String> products = new HashSet<>();

    public void add(String product) {
        products.add(product);
    }

    public void remove(String product) {
        products.remove(product);
    }

    public void clear() {
        products.clear();
    }

    public Set<String> getContents() {
        return products;
    }
}
