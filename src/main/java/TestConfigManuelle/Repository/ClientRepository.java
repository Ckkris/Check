package TestConfigManuelle.Repository;

import TestConfigManuelle.Entities.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by christophe on 3/17/2015.
 */
public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> findByNom(String nom);
}
