package ma.atos.agency.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agency {

    @Id
    private Long code;
    private String name;
    private String adress;
    @OneToMany(mappedBy = "agency")
    private List<Gestionnaire> list;
    @OneToMany(mappedBy = "agency")
    private List<Client> clientList;
    private boolean status;

}
