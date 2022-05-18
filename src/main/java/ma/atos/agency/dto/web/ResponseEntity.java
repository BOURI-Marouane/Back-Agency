package ma.atos.agency.dto.web;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseEntity {
    private org.springframework.http.ResponseEntity response;

    public ResponseEntity(org.springframework.http.ResponseEntity responseEntity) {
        this.response = responseEntity;
    }
}
