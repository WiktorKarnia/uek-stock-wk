package pl.wkarnia.stock.sales;

import pl.wkarnia.stock.productcatalog.Product;

public interface ProductDetailsProvider {
    ProductDetails getProductDetails(String productId);
}
