package ma.atos.agency.services;

import ma.atos.agency.entities.Privilege;
import ma.atos.agency.exceptions.InvalidPrivilegeNameException;
import ma.atos.agency.exceptions.ListPrivilegeEmptyException;
import ma.atos.agency.exceptions.PrivilegeNotFoundException;

import java.util.List;

public interface IPrivilegeService {

    Privilege newPrivilege(Privilege privilege) throws InvalidPrivilegeNameException;
    List<Privilege> getAll() throws ListPrivilegeEmptyException;
    Privilege getPrivilege(Long id) throws PrivilegeNotFoundException;
    String deletePrivilege(Long id) throws PrivilegeNotFoundException, InvalidPrivilegeNameException;
    Privilege replacePrivilege(Privilege privilege) throws PrivilegeNotFoundException, InvalidPrivilegeNameException;

}
