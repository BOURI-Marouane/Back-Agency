package ma.atos.agency.web.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgencyRequestDto {

    @NotEmpty
    @Size(min = 2,message = "agency name should have at least 2 characteres")
    private String name;
    @NotEmpty
    @Size(min = 5, message = "agency adress should have at least 5 characteres")
    private String adress;

    private boolean isEnabled;


}
