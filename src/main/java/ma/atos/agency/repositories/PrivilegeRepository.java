package ma.atos.agency.repositories;

import ma.atos.agency.entities.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public  interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
}
