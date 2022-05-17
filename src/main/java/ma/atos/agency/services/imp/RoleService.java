package ma.atos.agency.services.imp;

import ma.atos.agency.dto.RoleDto;
import ma.atos.agency.entities.Privilege;
import ma.atos.agency.entities.Role;
import ma.atos.agency.exceptions.RoleNotFoundException;
import ma.atos.agency.mappers.repositories.PrivilegeRepository;
import ma.atos.agency.mappers.repositories.RoleRepository;
import ma.atos.agency.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class RoleService implements IRoleService {
    @Autowired
    private PrivilegeRepository privilegeRepository;
    @Autowired
    private RoleRepository roleRepository;

    public List<RoleDto> getAll() {
        List<RoleDto> listdto = new ArrayList<>();
        List<Role> list = roleRepository.findAll();
        list.forEach( item -> {
            Set<String> privileges = new HashSet<>();
            item.getPrivileges().forEach(privilege -> {
                privileges.add(privilege.getName());
            });
            RoleDto dtoItem = new RoleDto(item.getId(),item.getName(),privileges);
            listdto.add(dtoItem);
        });
        return listdto;
    }

    public Role newRole(RoleDto roleDto){

        Role role = new Role(0L,roleDto.getName(), new HashSet<>());
        roleDto.getPrivileges().forEach(privilege ->{
           Privilege p = privilegeRepository.findByName(privilege);
           if( p != null)
           role.getPrivileges().add(p);
        });
        return roleRepository.save(role);

    }

    public RoleDto getRole(Long id) throws RoleNotFoundException {
        Role role = roleRepository.findById(id).orElseThrow( () -> new RoleNotFoundException(id));
        return new RoleDto(role);
    }

    public Role replaceRole(RoleDto newRoleDto,Long id) throws RoleNotFoundException {
        Set<Privilege> listPriveleges = new HashSet<>();
        newRoleDto.getPrivileges().forEach(privilege ->{
            Privilege p = privilegeRepository.findByName(privilege);
            if( p != null)
                listPriveleges.add(p);
        });

        return roleRepository.findById(id)
                .map(role -> {
                    role.setName(newRoleDto.getName());
                    role.setPrivileges(listPriveleges);
                    return roleRepository.save(role);
                })
                .orElseThrow(() -> new RoleNotFoundException(id));
    }

    public void deleteRole(Long id) throws RoleNotFoundException {
        Role role = roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException(id));
        for (Privilege privilege : role.getPrivileges()) {
            privilege.remove(role);
            privilegeRepository.save(privilege);

        }
        roleRepository.save(role);
        roleRepository.deleteById(id);
    }


}
