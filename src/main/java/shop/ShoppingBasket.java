package shop;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {
    private final List<String> products = new ArrayList<>();

    public void add(String product) {
        products.add(product);
    }

    public List<String> getContents() {
        return products;
    }
}
