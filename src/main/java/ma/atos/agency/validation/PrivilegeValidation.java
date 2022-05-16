package ma.atos.agency.validation;

import ma.atos.agency.entities.Privilege;
import ma.atos.agency.parametrage.privilege.ConfigurationPrivilege;
import ma.atos.agency.parametrage.privilege.ConfigurationPrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class PrivilegeValidation {

    @Autowired
    ConfigurationPrivilegeRepository configurationPrivilegeRepository;

    public boolean isValid(Privilege privilege){
        AtomicBoolean isValid = new AtomicBoolean(false);
        List<ConfigurationPrivilege> list = configurationPrivilegeRepository.findAll();
        if(list.isEmpty())
            isValid.set(true);
        else {
        list.stream().forEach(item -> {
                if(item.getName().equals(privilege.getName()))
                    isValid.set(true);
            });
        }
        return isValid.get();
    }
}
