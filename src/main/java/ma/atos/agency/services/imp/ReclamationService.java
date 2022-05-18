package ma.atos.agency.services.imp;

import ma.atos.agency.dto.web.ReclamationDto;
import ma.atos.agency.services.IReclamationService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class ReclamationService implements IReclamationService {
    /**
     * @param id
     * @return
     */
    @Override
    public ResponseEntity getClientReclamation(Long id) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://192.168.8.125:8080/complains/complain-customer"+id;
        URI uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<ReclamationDto> result = restTemplate.pos

        return result;
    }
}
