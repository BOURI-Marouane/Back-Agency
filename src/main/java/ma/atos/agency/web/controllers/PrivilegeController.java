package ma.atos.agency.web.controllers;

import ma.atos.agency.dto.PrivilegeDto;
import ma.atos.agency.entities.Privilege;
import ma.atos.agency.exceptions.*;
import ma.atos.agency.mappers.PrivilegeMapper;
import ma.atos.agency.services.imp.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PrivilegeController {
    @Autowired
    private PrivilegeService privilegeService;
    @Autowired
    private PrivilegeMapper privilegeMapper;

    @PostMapping("/allpriviliges")
    Map<String,Object> all() {
        Map<String,Object> map = new HashMap<String,Object>();
        List<PrivilegeDto> listDto = new ArrayList<>();
        try {
            privilegeService.getAll().stream().forEach(item -> {
                listDto.add(privilegeMapper.MaptoDto(item));
            });
            map.put("success", true);
            map.put("privileges",listDto);

        }catch (ListPrivilegeEmptyException e){
            map.put("success", false);
            map.put("Message",e.getMessage());

        }catch (Exception e) {
            map.put("success", false);
            e.printStackTrace();
            map.put("Message",e.getMessage());

        }
        return map;
    }

    @PostMapping("/AddPrivilege")
    Map<String,Object> createPrivilege(@RequestBody PrivilegeDto newPrivilegeDto) {
        Map<String,Object> map = new HashMap<>();
        try {
            Privilege privilege= privilegeService.newPrivilege(privilegeMapper.MaptoEntity(newPrivilegeDto));
            newPrivilegeDto.setId(privilege.getId());
            map.put("sucess",true);
            map.put("new privilege",newPrivilegeDto);
        }catch (InvalidPrivilegeNameException e){
            map.put("sucess",false);
            map.put("message",e.getMessage());
        }catch (Exception e){
            map.put("sucess",false);
            map.put("message",e.getMessage());
        }
        return map;
    }


    @PostMapping("/FindPrivilegeById")
    Map<String, Object> one(@RequestBody Map<String,Object> params)  {
        Map<String,Object> map = new HashMap<>();
        Integer id1 = (Integer) params.get("id");
        Long id = new Long(id1);
        try {
            PrivilegeDto privilegeDto = privilegeMapper.MaptoDto(privilegeService.getPrivilege(id));
            map.put("success",true);
            map.put("Privilege",privilegeDto);
        } catch (PrivilegeNotFoundException e) {
            map.put("success",false);
            map.put("message",e.getMessage());
        } catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }

    @PostMapping("/UpdatePrivilege")
    Map<String,Object> updatePrivilege(@RequestBody PrivilegeDto newPrivilegeDto){
        Map<String,Object> map = new HashMap<>();
        try {
            Privilege privilege = privilegeService.replacePrivilege(privilegeMapper.MaptoEntity(newPrivilegeDto));
            map.put("success",true);
            map.put("Privilege",newPrivilegeDto);
        } catch (InvalidPrivilegeNameException e) {
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

    @PostMapping("/DeletePrivilege")
    Map<String,Object> deletePrivilege(@RequestBody Map<String,Object> params)  {
        Map<String,Object> map = new HashMap<>();
        Integer idhelp = (Integer) params.get("id");
        Long id = new Long(idhelp);
        try {
            String privilege = privilegeService.deletePrivilege(id);
            map.put("success",true);
            map.put("deleted role",privilege);
        } catch (InvalidPrivilegeNameException e) {
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
}
