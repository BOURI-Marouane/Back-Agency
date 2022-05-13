package ma.atos.agency.repositories;

import ma.atos.agency.entities.Gestionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GestionnaireRepository extends JpaRepository<Gestionnaire,Long> {

    Gestionnaire findByRegistrationNumber(Long matricule);
}
