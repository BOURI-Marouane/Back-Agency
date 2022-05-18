package ma.atos.agency.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    private String name;

    private String adress;

    @OneToMany(mappedBy = "agency_id")
    private List<Gestionnaire> gestionnaires;

    @OneToMany(mappedBy = "agency")
    private List<Client> clientList;

    private boolean isEnabled;


    private boolean status;


}
