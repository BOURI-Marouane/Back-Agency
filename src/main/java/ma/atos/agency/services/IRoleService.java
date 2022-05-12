package ma.atos.agency.services;

import ma.atos.agency.dto.RoleDto;
import ma.atos.agency.entities.Role;
import ma.atos.agency.exceptions.RoleNotFoundException;

import java.util.List;

public interface IRoleService {
    List<RoleDto> getAll();
    Role newRole(RoleDto roleDto);
    RoleDto getRole(Long id) throws RoleNotFoundException;
    Role replaceRole(RoleDto newRoleDto,Long id) throws RoleNotFoundException;
    void deleteRole(Long id) throws RoleNotFoundException;
}
