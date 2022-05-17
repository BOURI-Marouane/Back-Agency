package ma.atos.agency.dto;

import lombok.*;
import ma.atos.agency.entities.Agency;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
public class ClientDto {
    private long clientId;
    private String name;
    private Agency agency;



}
