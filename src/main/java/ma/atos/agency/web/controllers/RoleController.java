
package ma.atos.agency.web.controllers;

import ma.atos.agency.dto.RoleDto;
import ma.atos.agency.entities.Role;
import ma.atos.agency.exceptions.RoleNameInvalidExeption;
import ma.atos.agency.exceptions.RoleNotFoundException;
import ma.atos.agency.services.imp.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/roles")
    List<RoleDto> all() {
        return roleService.getAll();
    }

    @PostMapping("/roles")
    RoleDto createRole(@RequestBody RoleDto newRoleDto) throws RoleNameInvalidExeption {
        try{
            return new RoleDto(roleService.newRole(newRoleDto));
        }catch (Exception e){
            throw new RoleNameInvalidExeption();
        }

    }
    @GetMapping("/roles/{id}")
    RoleDto one(@PathVariable Long id) throws RoleNotFoundException {
        return roleService.getRole(id);
    }
    @PutMapping("/roles/{id}")
    RoleDto updateRole(@RequestBody RoleDto newRoleDto, @PathVariable Long id) throws RoleNotFoundException {
        Role role = roleService.replaceRole(newRoleDto,id);
        return  new RoleDto(role);
    }

    @DeleteMapping("/roles/{id}")
    void deleteRole(@PathVariable Long id) throws RoleNotFoundException {
        roleService.deleteRole(id);
    }

}
