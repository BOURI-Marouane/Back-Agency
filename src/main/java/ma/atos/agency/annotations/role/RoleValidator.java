package ma.atos.agency.annotations.role;

import ma.atos.agency.parametrage.privilege.ConfigurationPrivilege;
import ma.atos.agency.parametrage.privilege.ConfigurationPrivilegeRepository;
import ma.atos.agency.parametrage.role.ConfigurationRole;
import ma.atos.agency.parametrage.role.ConfigurationRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class RoleValidator implements ConstraintValidator<RoleValidation, String>
{
    @Autowired
    private ConfigurationRoleRepository configurationRoleRepository;

    public boolean isValid(String roleName, ConstraintValidatorContext cxt) {
        AtomicBoolean isValid = new AtomicBoolean(false);
        List<ConfigurationRole> list = configurationRoleRepository.findAll();
        if (!CollectionUtils.isEmpty(list)) {
            list.stream().forEach(ui -> {
                if(ui.getName().equals(roleName)){
                    isValid.set(true);
                }
            });
        }
        return isValid.get();

    }
}
