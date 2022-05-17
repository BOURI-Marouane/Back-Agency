package ma.atos.agency.repositories;

import ma.atos.agency.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByName(String name);
}
