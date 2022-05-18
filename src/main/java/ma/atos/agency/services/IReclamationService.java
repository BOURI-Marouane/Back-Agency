package ma.atos.agency.services;


import org.springframework.http.ResponseEntity;

import javax.xml.ws.Response;
import java.net.URISyntaxException;

public interface IReclamationService {

        ResponseEntity getClientReclamation(Long id) throws URISyntaxException;
}
