package shop;

public class AlwaysInStockInventory implements Inventory {
    @Override
    public boolean inStock(String product) {
        return true;
    }
}
