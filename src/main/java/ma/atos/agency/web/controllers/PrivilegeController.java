package ma.atos.agency.web.controllers;

import ma.atos.agency.dto.PrivilegeDto;
import ma.atos.agency.entities.Privilege;
import ma.atos.agency.exceptions.PrivilegeNameInvalidException;
import ma.atos.agency.exceptions.PrivilegeNotFoundException;
import ma.atos.agency.exceptions.RoleNotFoundException;
import ma.atos.agency.services.imp.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PrivilegeController {
    @Autowired
    private PrivilegeService privilegeService;

    @GetMapping("/privileges")
    List<PrivilegeDto> all() {
        return privilegeService.getAll();
    }

    @PostMapping("/privileges")
    PrivilegeDto createPrivilege(@RequestBody PrivilegeDto newPrivilegeDto) throws PrivilegeNameInvalidException {
        Privilege privilege;
        try {
             privilege = privilegeService.newPrivilege(newPrivilegeDto);
        }catch(Exception e){
            throw new PrivilegeNameInvalidException();
        }
        return new PrivilegeDto(privilege.getId(), privilege.getName());
    }


    @GetMapping("/privileges/{id}")
    PrivilegeDto one(@PathVariable Long id) throws PrivilegeNotFoundException {
        return privilegeService.getPrivilege(id);
    }

    @PutMapping("/privileges/{id}")
    PrivilegeDto updatePrivilege(@RequestBody PrivilegeDto newPrivilegeDto, @PathVariable Long id) throws PrivilegeNotFoundException {
        Privilege privilege = privilegeService.replacePrivilege(newPrivilegeDto,id);
        return  new PrivilegeDto(privilege.getId(), privilege.getName());
    }

    @DeleteMapping("/privileges/{id}")
    void deletePrivilege(@PathVariable Long id) throws PrivilegeNotFoundException {
        privilegeService.deletePrivilege(id);
    }
}
