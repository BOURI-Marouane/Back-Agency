package ma.atos.agency.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.agency.entities.Role;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
public class RoleDto {

    private Long id;
    private String name;
    private Set<String> privileges;

    public RoleDto(Role role){
        this.id = role.getId();
        this.name = role.getName();
        Set<String> listPrivileges = new HashSet<>();
        role.getPrivileges().forEach( privilege -> {
            listPrivileges.add(privilege.getName());
        });
        this.privileges = listPrivileges;
    }
}
