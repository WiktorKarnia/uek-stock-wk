package pl.wkarnia.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.wkarnia.stock.productcatalog.ImagesStorage;
import pl.wkarnia.stock.productcatalog.ProductCatalogFacade;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public ProductCatalogFacade createProductCatalog(ImagesStorage storage) {
        return new ProductCatalogFacade();
    }

    @Bean
    public ImagesStorage crateProductStorage() {
        return new ImagesStorage();
    }
}
