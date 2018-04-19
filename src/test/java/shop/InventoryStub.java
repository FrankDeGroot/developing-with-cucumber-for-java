package shop;

public class InventoryStub implements Inventory {

    @Override
    public boolean inStock(String product) {
        switch (product) {
            case "banana":
            case "apple":
            case "blood orange":
                return true;
            default:
                return false;
        }
    }
}
