package ma.atos.agency.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;
}
