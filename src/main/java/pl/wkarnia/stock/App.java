package pl.wkarnia.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.wkarnia.stock.payment.PayU;
import pl.wkarnia.stock.productcatalog.Product;
import pl.wkarnia.stock.productcatalog.ProductCatalog;
import pl.wkarnia.stock.productcatalog.ProductRepository;
import pl.wkarnia.stock.sales.*;
import pl.wkarnia.stock.sales.basket.BasketStorage;
import pl.wkarnia.stock.sales.catalog.ProductDetails;
import pl.wkarnia.stock.sales.catalog.ProductDetailsProvider;
import pl.wkarnia.stock.sales.offerting.OfferMaker;
import pl.wkarnia.stock.sales.ordering.InMemoryReservationStorage;
import pl.wkarnia.stock.sales.ordering.JpaReservationStorage;
import pl.wkarnia.stock.sales.ordering.ReservationRepository;
import pl.wkarnia.stock.sales.payment.PayUPaymentGateway;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public ProductCatalog createProductCatalog(
            ProductRepository productRepository) {
        ProductCatalog productCatalog = new ProductCatalog(productRepository);
        String productId1 = productCatalog.addProduct(
                "First example product",
                BigDecimal.valueOf(20.10),
                Arrays.asList("tag1", "tag2"),
                "https://picsum.photos/300/200"
        );
        productCatalog.publish(productId1);

        String productId2 = productCatalog.addProduct(
                "Second example product",
                BigDecimal.valueOf(10.10),
                Arrays.asList("tag2"),
                "https://picsum.photos/200/300"
        );
        productCatalog.publish(productId2);

        String productId3 = productCatalog.addProduct(
                "Third example product",
                BigDecimal.valueOf(30.10),
                Arrays.asList("tag2"),
                "https://picsum.photos/301/201"
        );
        productCatalog.publish(productId3);

        return productCatalog;
    }

    @Bean
    public SalesFacade createSalesFacade(ProductDetailsProvider productDetailsProvider, PayU payU) {
        return new SalesFacade(
                new BasketStorage(),
                productDetailsProvider,
                new OfferMaker(productDetailsProvider),
                new InMemoryReservationStorage(),
                new PayUPaymentGateway(payU));
    }

    @Bean
    public ProductDetailsProvider productDetailsProvider(ProductCatalog productCatalog ) {
        return (id) -> {
            Product product = productCatalog.getById(id);
            return new ProductDetails(
                    product.getId(),
                    product.getPrice()
            );
        };
    }

    @Bean
    public JpaReservationStorage createJpaReervationStorage(ReservationRepository reservationRepository) {
        return new JpaReservationStorage(reservationRepository);
    }
}
