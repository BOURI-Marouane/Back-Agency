package ma.atos.agency.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.atos.agency.entities.Agency;

@Getter
@Setter
@ToString
public class ClientDto {
    private long clientId;
    private String name;
    private String agency_name;




}
