package pl.wkarnia.stock.crm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClientDataRepository extends
        JpaRepository<ClientData, Integer> {
}
