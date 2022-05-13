package ma.atos.agency.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.agency.annotations.role.RoleValidation;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @RoleValidation()
    private String name;

    @ManyToMany
    @JoinTable(
            name = "role_privilege",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id"))
    Set<Privilege> privileges;

    public void addPrivilege(Privilege privilege) {
        privileges.add(privilege);
        privilege.getRoles().add(this);
    }

    public void removePrivilege(Privilege privilege) {
        privileges.remove(privilege);
        privilege.getRoles().remove(this);
    }

}
