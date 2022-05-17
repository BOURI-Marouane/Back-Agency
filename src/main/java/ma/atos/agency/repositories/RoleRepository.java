package ma.atos.agency.repositories;

import ma.atos.agency.entities.Privilege;
import ma.atos.agency.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);

}
