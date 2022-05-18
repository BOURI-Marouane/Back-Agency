package ma.atos.agency.dto.web;

import lombok.Data;
import ma.atos.agency.dto.ClientDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@Data
public class ResponseListClientDto extends ResponseEntity {

    List<ClientDto> clients ;

    public ResponseListClientDto(org.springframework.http.ResponseEntity responseEntity, List<ClientDto> clientDtos) {
        super(responseEntity);
        this.clients = clientDtos;
    }
}
