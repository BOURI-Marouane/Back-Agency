package ma.atos.agency.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gestionnaire {

    @Id
    private Long registrationNumber;

    private String fullName;

    private String level;

    @ManyToOne
    @JoinColumn(name="agency_id", nullable = false)
    private Agency agency;
}
