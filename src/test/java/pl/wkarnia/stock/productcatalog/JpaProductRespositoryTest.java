package pl.wkarnia.stock.productcatalog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.wkarnia.stock.productcatalog.Product;
import pl.wkarnia.stock.productcatalog.ProductRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

@SpringBootTest
public class JpaProductRespositoryTest {
    @Autowired
    ProductRepository productRepository;

    @Test
    void itsStoredProduct() {
        UUID id = UUID.randomUUID();
        Product product = new Product(
                id,
                "My prod",
                BigDecimal.ONE,
                Arrays.asList("k1", "k2"),
                "media.jpeg");
        productRepository.save(product);

        Product loaded = productRepository.findById(id.toString()).get();
    }
}
