package ma.atos.agency.web.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.agency.entities.Agency;
import ma.atos.agency.web.dto.GeneraleDtoResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GestionnaireResponseDto extends GeneraleDtoResponse {

    private String fullName;
    private String level;
    //private Long agency_id; // Infinity LOOP
}
