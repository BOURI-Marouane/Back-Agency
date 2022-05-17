package ma.atos.agency.validation;

import ma.atos.agency.entities.Privilege;
import ma.atos.agency.entities.Role;
import ma.atos.agency.parametrage.privilege.ConfigurationPrivilege;
import ma.atos.agency.parametrage.privilege.ConfigurationPrivilegeRepository;
import ma.atos.agency.parametrage.role.ConfigurationRole;
import ma.atos.agency.parametrage.role.ConfigurationRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
@Component
public class RoleValidation {

    @Autowired
    ConfigurationRoleRepository configurationRoleRepository;

    public boolean isValid(Role role){
        AtomicBoolean isValid = new AtomicBoolean(false);
        List<ConfigurationRole> list = configurationRoleRepository.findAll();
        if(list.isEmpty())
            isValid.set(true);
        else {
            for (ConfigurationRole item : list) {
                if (item.getName().equals(role.getName()))
                    isValid.set(true);
            }
        }
        return isValid.get();
    }
}
