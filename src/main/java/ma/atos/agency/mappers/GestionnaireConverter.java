package ma.atos.agency.mappers;

import ma.atos.agency.dto.GestionnaireDto;
import ma.atos.agency.entities.Gestionnaire;
import org.modelmapper.ModelMapper;

public class GestionnaireConverter {
    public static Gestionnaire toGestionnaire(GestionnaireDto gestionnaireDto)
    {
        Gestionnaire gestionnaire = new Gestionnaire();
        ModelMapper modelMapper = new ModelMapper();
        gestionnaire=modelMapper.map(gestionnaireDto, Gestionnaire.class);
        return gestionnaire;
    }

    public static GestionnaireDto toGestionnaireDto(Gestionnaire gestionnaire)
    {
        GestionnaireDto gestionnaireDto = new GestionnaireDto();
        ModelMapper modelMapper = new ModelMapper();
        gestionnaireDto=modelMapper.map(gestionnaire,GestionnaireDto.class);
        return gestionnaireDto;

    }
}
