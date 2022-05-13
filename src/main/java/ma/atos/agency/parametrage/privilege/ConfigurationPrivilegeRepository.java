package ma.atos.agency.parametrage.privilege;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigurationPrivilegeRepository extends JpaRepository<ConfigurationPrivilege,Integer> {
    @Cacheable("privileges")
    List<ConfigurationPrivilege> findAll();
}
