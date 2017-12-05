package shop;

import java.util.Objects;

public class Item {
    private int count;
    private final String product;

    public Item(String product) {
        this.product = product;
        this.count = 1;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return count == item.count &&
                Objects.equals(product, item.product);
    }

    @Override
    public int hashCode() {

        return Objects.hash(count, product);
    }
}
