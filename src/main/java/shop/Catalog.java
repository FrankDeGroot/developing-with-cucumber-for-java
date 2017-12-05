package shop;

import java.math.BigDecimal;

public interface Catalog {
    BigDecimal getPrice(String product);
}
