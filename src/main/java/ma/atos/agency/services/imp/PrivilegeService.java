package ma.atos.agency.services.imp;


import ma.atos.agency.entities.Privilege;
import ma.atos.agency.entities.Role;
import ma.atos.agency.exceptions.InvalidPrivilegeNameException;
import ma.atos.agency.exceptions.ListPrivilegeEmptyException;
import ma.atos.agency.exceptions.PrivilegeNotFoundException;
import ma.atos.agency.repositories.PrivilegeRepository;
import ma.atos.agency.repositories.RoleRepository;
import ma.atos.agency.services.IPrivilegeService;
import ma.atos.agency.validation.PrivilegeValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrivilegeService implements IPrivilegeService {

    @Autowired
    private PrivilegeRepository privilegeRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PrivilegeValidation privilegeValidation;


    @Override
    public List<Privilege> getAll() throws ListPrivilegeEmptyException {
        List<Privilege> list = privilegeRepository.findAll();
        if (list.isEmpty())
            throw new ListPrivilegeEmptyException();
        return list;
    }
    @Override
    public Privilege newPrivilege(Privilege privilege) throws InvalidPrivilegeNameException {
        if(privilegeValidation.isValid(privilege))
            return privilegeRepository.save(privilege);
        throw new InvalidPrivilegeNameException();
    }


    @Override
    public Privilege getPrivilege(Long id) throws PrivilegeNotFoundException {
        Optional<Privilege> privilege = privilegeRepository.findById(id);
        if(privilege.isPresent())
            return privilege.get();
        throw new PrivilegeNotFoundException();
    }
    @Override
    public Privilege replacePrivilege(Privilege privilege) throws InvalidPrivilegeNameException, PrivilegeNotFoundException {
        this.getPrivilege(privilege.getId());
        return this.newPrivilege(privilege);
    }
    @Override
    public String deletePrivilege(Long id) throws PrivilegeNotFoundException, InvalidPrivilegeNameException {
        Privilege privilege = this.getPrivilege(id);
        privilege.setRoles(null);
        this.replacePrivilege(privilege);
        privilegeRepository.delete(privilege);
        return privilege.getName();
        }

    }






