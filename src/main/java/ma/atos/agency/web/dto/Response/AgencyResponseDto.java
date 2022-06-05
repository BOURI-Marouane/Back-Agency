package ma.atos.agency.web.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.agency.entities.Client;
import ma.atos.agency.entities.Gestionnaire;
import ma.atos.agency.web.dto.GeneraleDtoResponse;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgencyResponseDto extends GeneraleDtoResponse {

    private Long code;
    private String adress;
    private String name;
    private boolean status;
    private List<Gestionnaire> gestionnaires = new ArrayList<>();
    private List<Client> client = new ArrayList<>();
}
