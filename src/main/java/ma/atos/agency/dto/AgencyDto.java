package ma.atos.agency.dto;

import lombok.*;

@Getter
@Setter
@ToString
public class AgencyDto {

    private Long code;
    private String name;
    private String adress;
    private boolean status;

}
