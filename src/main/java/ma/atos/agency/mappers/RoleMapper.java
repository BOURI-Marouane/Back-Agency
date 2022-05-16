package ma.atos.agency.mappers;


import ma.atos.agency.dto.RoleDto;
import ma.atos.agency.entities.Privilege;
import ma.atos.agency.entities.Role;
import ma.atos.agency.exceptions.PrivilegeNotFoundException;
import ma.atos.agency.repositories.PrivilegeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RoleMapper {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    PrivilegeRepository privilegeRepository;

    public Role MaptoEntity(RoleDto roleDto) throws PrivilegeNotFoundException{
        Role role = new Role();
        role.setName(roleDto.getName());
        role.setId(roleDto.getId());
        Set<Privilege> privileges = null;
        if(!roleDto.getPrivileges().isEmpty()) {
            privileges = new HashSet<>();
            for (String item : roleDto.getPrivileges()) {
                Optional<Privilege> privilege = privilegeRepository.findByName(item);
                if (!privilege.isPresent())
                    throw new PrivilegeNotFoundException();
                privileges.add(privilege.get());
            }
        }
        role.setPrivileges(privileges);
        return role;
    }

    public RoleDto MaptoDto(Role role){
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setName(role.getName());
        Set<String> privileges = new HashSet<>();
        role.getPrivileges().stream().forEach(item -> {
            privileges.add(item.getName());
        });
        roleDto.setPrivileges(privileges);
        return roleDto;
    }

}
