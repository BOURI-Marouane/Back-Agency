package ma.atos.agency.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GestionnaireDto {

    private Long registrationNumber;

    private String fullName;

    private String level;

    private boolean status;
}
