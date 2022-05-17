package ma.atos.agency.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.agency.entities.Agency;
import ma.atos.agency.entities.Role;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GestionnaireDto {

    private Long registration_number;

    private String fullName;

    private String level;

    private boolean status;

    private List<Role> roles;

    private Agency agency_id;

}
