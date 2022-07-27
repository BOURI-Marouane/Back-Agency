package ma.atos.agency.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Data

public class Gestionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registration_number;

    private String fullName;

    private String level;

    @OneToMany(mappedBy = "gestionnaire")
    private List<Role> roles;

    @ManyToOne
    @JoinColumn(name="agency_id", nullable = true)
    @JsonIgnore
    private Agency agency_id;
}
