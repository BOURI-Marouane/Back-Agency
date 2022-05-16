package ma.atos.agency.services.imp;

import ma.atos.agency.dto.RoleDto;
import ma.atos.agency.entities.Privilege;
import ma.atos.agency.entities.Role;
import ma.atos.agency.exceptions.InvalidRoleNameException;
import ma.atos.agency.exceptions.ListRoleEmptyException;
import ma.atos.agency.exceptions.PrivilegeNotFoundException;
import ma.atos.agency.exceptions.RoleNotFoundException;
import ma.atos.agency.repositories.PrivilegeRepository;
import ma.atos.agency.repositories.RoleRepository;
import ma.atos.agency.services.IRoleService;
import ma.atos.agency.validation.RoleValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class RoleService implements IRoleService {
    @Autowired
    private PrivilegeRepository privilegeRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleValidation roleValidation;

    public List<Role> getAll() throws ListRoleEmptyException {
        List<Role> list = roleRepository.findAll();
        if (list.isEmpty())
            throw new ListRoleEmptyException();
        return list;
    }

    public Role newRole(Role role) throws InvalidRoleNameException {

        if(roleValidation.isValid(role))
            return roleRepository.save(role);
        throw new InvalidRoleNameException();

    }

    public Role getRole(Long id) throws RoleNotFoundException {
        Optional<Role> privilege = roleRepository.findById(id);
        if(privilege.isPresent())
            return privilege.get();
        throw new RoleNotFoundException();
    }

    public Role replaceRole(Role role) throws RoleNotFoundException, InvalidRoleNameException {
        this.getRole(role.getId());
        return this.newRole(role);
    }

    public String deleteRole(Long id) throws RoleNotFoundException, InvalidRoleNameException {
        Role role = this.getRole(id);
        role.setPrivileges(null);
        this.replaceRole(role);
        roleRepository.delete(role);
        return role.getName();
    }


}
