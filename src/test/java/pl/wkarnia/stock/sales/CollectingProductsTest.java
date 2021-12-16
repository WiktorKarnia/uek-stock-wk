package pl.wkarnia.stock.sales;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectingProductsTest {

    @Test
    void itAllowsToAddProductsToBasket(){
        String productId = thereIsProduct("product 1");
        String customerId = thereIsCustomer("Kuba");
        SalesFacade sales = thereIsSalesModule()

        //Act
        sales.addProductToBasket(customerId, productId);
        //Assert
        thereIsXProductsInCustomersBasket(1, customerId);
    }

    private void thereIsXProductsInCustomersBasket(int productsCount, String customerId) {
    Basket customerBasket = loadBasketForCustomer(customerId);
    assertEquals(productsCount, customerBasket);
    }

    private Basket loadBasketForCustomer(String customerId) {
        return null;
    }

    private String thereIsCustomer(String customerId) {
        return null;
    }

    private SalesFacade thereIsSalesModule() {
        return new SalesFacade(
                new
        )
    }

    private String thereIsProduct(String productId) {
        return null;

    }
}
