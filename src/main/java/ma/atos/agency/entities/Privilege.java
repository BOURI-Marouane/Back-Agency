package ma.atos.agency.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.agency.annotations.privilege.PrivilegeValidation;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @PrivilegeValidation()
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Set<Role> roles;

    public void addRole(Role role) {
        roles.add(role);
        role.getPrivileges().add(this);
    }

    public void remove(Role role) {
        roles.remove(role);
        role.getPrivileges().remove(this);
    }

}



