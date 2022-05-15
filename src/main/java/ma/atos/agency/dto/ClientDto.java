package ma.atos.agency.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.agency.entities.Agency;

@Data @AllArgsConstructor @NoArgsConstructor
public class ClientDto {
    private long clientId;
    private String name;
    private Agency agency;
}
