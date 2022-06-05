package ma.atos.agency.dto;

import lombok.*;
import ma.atos.agency.entities.Client;
import ma.atos.agency.entities.Gestionnaire;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class AgencyDto {

    private Long code;
    private String name;
    private String adress;
    private boolean status;
    private List<Gestionnaire> gestionnaires = new ArrayList<>();
    private List<Client> client = new ArrayList<>();

}
