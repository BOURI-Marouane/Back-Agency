package ma.atos.agency.repositories;

import ma.atos.agency.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface RoleRepository extends JpaRepository<Role,Long> {
}
