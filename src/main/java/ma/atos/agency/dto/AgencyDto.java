package ma.atos.agency.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgencyDto {

    private Long code;
    private String name;
    private String adress;
    private boolean status;

}
