package ma.atos.agency.dto;



import ma.atos.agency.entities.Agency;
import ma.atos.agency.entities.Role;

import java.util.List;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class GestionnaireDto {

    private Long registration_number;

    private String fullName;

    private String level;

    private boolean status;

    private List<Role> roles;

    private Agency agency_id;

}
