package shop;

public class CatalogStub implements Catalog {

    @Override
    public int getPrice(String product) {
        switch (product) {
            case "banana": return 1;
            case "apple": return 2;
            case "blood orange": return 3;
            default: return 4;
        }
    }
}
