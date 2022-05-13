package ma.atos.agency.repositories;

import ma.atos.agency.entities.Agency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyRepository extends JpaRepository<Agency,Long> {
   Agency findByCode(Long code);
}
