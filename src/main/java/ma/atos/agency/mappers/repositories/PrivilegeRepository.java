package ma.atos.agency.mappers.repositories;

import ma.atos.agency.entities.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
        Privilege findByName(String name);

}
