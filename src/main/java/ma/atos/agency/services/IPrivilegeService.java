package ma.atos.agency.services;

import ma.atos.agency.dto.PrivilegeDto;
import ma.atos.agency.entities.Privilege;
import ma.atos.agency.exceptions.PrivilegeNotFoundException;

import java.util.List;

public interface IPrivilegeService {

    Privilege newPrivilege(PrivilegeDto privilegeDto);
    List<PrivilegeDto> getAll();
    PrivilegeDto getPrivilege(Long id) throws PrivilegeNotFoundException;
    void deletePrivilege(Long id) throws PrivilegeNotFoundException;
    Privilege replacePrivilege(PrivilegeDto newPrivilegeDto, Long id) throws PrivilegeNotFoundException;

}
