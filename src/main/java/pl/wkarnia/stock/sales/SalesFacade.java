package pl.wkarnia.stock.sales;

import pl.wkarnia.stock.productcatalog.Product;
import pl.wkarnia.stock.productcatalog.ProductCatalog;

public class SalesFacade {
    private BasketStorage basketStorage;
    private ProductDetails productDetails;

    public void addProductToBasket(String customerId, String productId) {
        Basket basket = loadBasketForCustomer(customerId);
        Product product = getProductById(productId);

        basket.add(product);

    }

    private Product getProductById(String productId) {
        return productCatalog.loadProduct;
    }

    private Basket loadBasketForCustomer(String customerId) {
        basketStorage.loadFor(customerId);

    }
}
