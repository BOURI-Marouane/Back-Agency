package ma.atos.agency.services.imp;


import ma.atos.agency.dto.PrivilegeDto;
import ma.atos.agency.entities.Privilege;
import ma.atos.agency.entities.Role;
import ma.atos.agency.exceptions.PrivilegeNotFoundException;
import ma.atos.agency.mappers.repositories.PrivilegeRepository;
import ma.atos.agency.mappers.repositories.RoleRepository;
import ma.atos.agency.services.IPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class PrivilegeService implements IPrivilegeService {

    @Autowired
    private PrivilegeRepository privilegeRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<PrivilegeDto> getAll() {
        List<PrivilegeDto> listdto = new ArrayList<>();
        List<Privilege> list = privilegeRepository.findAll();
        list.forEach( item -> {
            PrivilegeDto dtoItem = new PrivilegeDto(item.getId(),item.getName());
            listdto.add(dtoItem);
        });
        return listdto;
    }
    @Override
    public Privilege newPrivilege(PrivilegeDto privilegeDto){
        Privilege privilege = new Privilege(0L,privilegeDto.getName(), new HashSet<>());
        return privilegeRepository.save(privilege);

    }
    @Override
    public PrivilegeDto getPrivilege(Long id) throws PrivilegeNotFoundException {
        Privilege privilege = privilegeRepository.findById(id).orElseThrow( () -> new PrivilegeNotFoundException(id));
        return new PrivilegeDto(privilege.getId(),privilege.getName());
    }
    @Override
    public Privilege replacePrivilege(PrivilegeDto newPrivilegeDto,Long id) throws PrivilegeNotFoundException {

        return privilegeRepository.findById(id)
                .map(privilege -> {
                    privilege.setName(newPrivilegeDto.getName());
                    return privilegeRepository.save(privilege);
                })
                .orElseThrow(() -> new PrivilegeNotFoundException(id));
    }
    @Override
    public void deletePrivilege(Long id) throws PrivilegeNotFoundException {

        Privilege privilege = privilegeRepository.findById(id).orElseThrow(() -> new PrivilegeNotFoundException(id));
        for (Role role : privilege.getRoles()) {
            role.removePrivilege(privilege);
            roleRepository.save(role);


        }
        privilegeRepository.save(privilege);
        privilegeRepository.deleteById(id);


    }





}
