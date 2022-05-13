package ma.atos.agency.parametrage.role;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigurationRoleRepository extends JpaRepository<ConfigurationRole,Integer> {
    @Cacheable("roles")
    List<ConfigurationRole> findAll();
}
