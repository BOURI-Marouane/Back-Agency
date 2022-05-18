
package ma.atos.agency.web.controllers;

import ma.atos.agency.dto.PrivilegeDto;
import ma.atos.agency.dto.RoleDto;
import ma.atos.agency.entities.Privilege;
import ma.atos.agency.entities.Role;
import ma.atos.agency.exceptions.*;
import ma.atos.agency.mappers.RoleMapper;
import ma.atos.agency.services.imp.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleMapper roleMapper;

    @PostMapping("/AllRoles")
    Map<String,Object> all() {
        Map<String,Object> map = new HashMap<String,Object>();
        List<RoleDto> listDto = new ArrayList<>();
        try {
            roleService.getAll().stream().forEach(item -> {
                listDto.add(roleMapper.MaptoDto(item));
            });
            map.put("success", true);
            map.put("roles",listDto);

        }catch (ListRoleEmptyException e){
            map.put("success", false);
            map.put("Message",e.getMessage());

        }catch (Exception e) {
            map.put("success", false);
            e.printStackTrace();
            map.put("Message",e.getMessage());

        }
        return map;
    }

    @PostMapping("/AddRole")
    Map<String,Object> createRole(@RequestBody RoleDto newRoleDto)  {
        Map<String,Object> map = new HashMap<>();
        try {
            Role role = roleService.newRole(roleMapper.MaptoEntity(newRoleDto));
            newRoleDto.setId(role.getId());
            map.put("sucess",true);
            map.put("new role",newRoleDto);
        }catch (InvalidRoleNameException e){
            map.put("sucess",false);
            map.put("message",e.getMessage());
        }catch (Exception e){
            map.put("sucess",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @PostMapping("/FindRoleById")
    Map<String,Object> one(@RequestBody Map<String,Object> params) throws RoleNotFoundException {
        Map<String,Object> map = new HashMap<>();
        Integer idhelp = (Integer) params.get("id");
        Long id = new Long(idhelp);
        try {
            RoleDto roleDto = roleMapper.MaptoDto(roleService.getRole(id));
            map.put("success",true);
            map.put("Privilege",roleDto);
        } catch (RoleNotFoundException e) {
            map.put("success",false);
            map.put("message",e.getMessage());
        } catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @PostMapping("/UpdateRole")
    Map<String, Object> updateRole(@RequestBody RoleDto newRoleDto){
        Map<String,Object> map = new HashMap<>();
        try {
            Role role = roleService.replaceRole(roleMapper.MaptoEntity(newRoleDto));
            map.put("success",true);
            map.put("Role",newRoleDto);
        } catch (InvalidRoleNameException e) {
            map.put("success",false);
            map.put("message",e.getMessage());
        } catch (RoleNotFoundException e) {
            map.put("success",false);
            map.put("message",e.getMessage());
        } catch (PrivilegeNotFoundException e) {
            map.put("success",false);
            map.put("message",e.getMessage());
        } catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }


    @PostMapping("/DeleteRole")
    Map<String,Object> deleteRole(@RequestBody Map<String,Object> params)  {
        Map<String,Object> map = new HashMap<>();
        Integer idhelp = (Integer) params.get("id");
        Long id = new Long(idhelp);
        try {
            String role = roleService.deleteRole(id);
            map.put("success",true);
            map.put("deleted role",role);
        } catch (InvalidRoleNameException e) {
            map.put("success",false);
            map.put("message",e.getMessage());
        } catch (RoleNotFoundException e) {
            map.put("success",false);
            map.put("message",e.getMessage());
        } catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }

        return map;

    }

}
