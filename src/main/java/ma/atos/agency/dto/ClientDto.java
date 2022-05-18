package ma.atos.agency.dto;

import lombok.*;
import ma.atos.agency.entities.Agency;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
public class ClientDto {
    private long id;
    private String name;
    private String agency_name;




}
