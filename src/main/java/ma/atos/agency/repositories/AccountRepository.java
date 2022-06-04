package ma.atos.agency.repositories;

import ma.atos.agency.entities.Account;
import ma.atos.agency.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository <Client, Long>{


    //String findby(String accountNumber);
}
