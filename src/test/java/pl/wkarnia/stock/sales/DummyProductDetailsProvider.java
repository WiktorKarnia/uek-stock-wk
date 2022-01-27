package pl.wkarnia.stock.sales;

import pl.wkarnia.stock.sales.catalog.ProductDetails;
import pl.wkarnia.stock.sales.catalog.ProductDetailsProvider;

import java.util.HashMap;
import java.util.Map;

public class DummyProductDetailsProvider implements ProductDetailsProvider {
    Map<String, ProductDetails> products;

    public DummyProductDetailsProvider() {
        this.products = new HashMap<>();
    }

    @Override
    public ProductDetails getProductDetails(String productId) {
        return products.get(productId);
    }
}
