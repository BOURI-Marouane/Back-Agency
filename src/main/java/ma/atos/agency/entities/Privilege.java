package ma.atos.agency.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Set<Role> roles;


}
