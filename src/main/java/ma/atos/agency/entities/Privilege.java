package ma.atos.agency.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
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



