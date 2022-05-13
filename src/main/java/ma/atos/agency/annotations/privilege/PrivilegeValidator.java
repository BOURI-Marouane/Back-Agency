package ma.atos.agency.annotations.privilege;

import ma.atos.agency.parametrage.privilege.ConfigurationPrivilege;
import ma.atos.agency.parametrage.privilege.ConfigurationPrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class PrivilegeValidator implements ConstraintValidator<PrivilegeValidation, String>
{
    @Autowired
    private ConfigurationPrivilegeRepository configurationPrivilegeRepository;


    public boolean isValid(String privilegeName, ConstraintValidatorContext cxt) {
        AtomicBoolean isValid = new AtomicBoolean(false);
        List<ConfigurationPrivilege> list = configurationPrivilegeRepository.findAll();
        if (!CollectionUtils.isEmpty(list)) {
            list.stream().forEach(ui -> {
                if(ui.getName().equals(privilegeName))
                    isValid.set(true);
            });
        }
        return isValid.get();
    }
}
