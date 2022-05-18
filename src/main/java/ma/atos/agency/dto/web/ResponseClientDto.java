package ma.atos.agency.dto.web;

import lombok.*;
import ma.atos.agency.dto.ClientDto;
import ma.atos.agency.entities.Agency;
import org.springframework.http.HttpStatus;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Getter
@Setter
@ToString
public class ResponseClientDto extends ResponseEntity {

    private ClientDto clientDto;

    public ResponseClientDto(org.springframework.http.ResponseEntity responseEntity,ClientDto clientDto) {
        super(responseEntity);
        this.clientDto = clientDto;
    }
}
