package ma.atos.agency.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "clientId")
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    @JsonIgnore
    private Agency agency;

}
