package ma.atos.agency.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.agency.annotations.privilege.PrivilegeValidation;

@AllArgsConstructor @NoArgsConstructor @Data
public class PrivilegeDto {

    private Long id;
    @PrivilegeValidation()
    private String name;

}
