package pl.wkarnia.stock.productcatalog;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Image, String> {
}
