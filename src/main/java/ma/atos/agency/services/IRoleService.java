package ma.atos.agency.services;

import ma.atos.agency.dto.RoleDto;
import ma.atos.agency.entities.Role;
import ma.atos.agency.exceptions.InvalidRoleNameException;
import ma.atos.agency.exceptions.ListRoleEmptyException;
import ma.atos.agency.exceptions.RoleNotFoundException;

import java.util.List;

public interface IRoleService {
    List<Role> getAll() throws ListRoleEmptyException;
    Role newRole(Role role) throws InvalidRoleNameException;
    Role getRole(Long id) throws RoleNotFoundException;
    Role replaceRole(Role Role) throws RoleNotFoundException,InvalidRoleNameException;
    String deleteRole(Long id) throws RoleNotFoundException, InvalidRoleNameException;
}
