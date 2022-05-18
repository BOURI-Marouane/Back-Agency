package ma.atos.agency.web.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GestionnaireRequestDto {

    private Long registration_number;
    @NotEmpty
    @Size(min = 5,message = "Manager fullName should have at least 5 characteres")
    private String fullName;
    @NotEmpty
    @Size(min = 5, message = "Manager level should have at least 5 characteres")
    private String level;
    private Long agency_id;

}
