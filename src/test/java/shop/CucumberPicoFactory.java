package shop;

import cucumber.runtime.java.picocontainer.PicoFactory;

public class CucumberPicoFactory extends PicoFactory {

    public CucumberPicoFactory() {
        addClass(InventoryStub.class);
        addClass(CatalogStub.class);
    }
}
