package ma.atos.agency.mappers;

import ma.atos.agency.dto.GestionnaireDto;
import ma.atos.agency.entities.Gestionnaire;
import ma.atos.agency.web.dto.Request.GestionnaireRequestDto;
import ma.atos.agency.web.dto.Response.GestionnaireResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GestionnaireConverter {

    @Autowired
    private ModelMapper modelMapper;
    public  Gestionnaire toGestionnaire(GestionnaireDto gestionnaireDto)
    {
        Gestionnaire gestionnaire = modelMapper.map(gestionnaireDto, Gestionnaire.class);
        return gestionnaire;
    }

    public  GestionnaireDto toGestionnaireDto(Gestionnaire gestionnaire)
    {
        GestionnaireDto gestionnaireDto = modelMapper.map(gestionnaire,GestionnaireDto.class);
        return gestionnaireDto;

    }

    public  GestionnaireDto ResquestToGestionnaireDto(GestionnaireRequestDto gestionnaireRequestDto)
    {
        GestionnaireDto gestionnaireDto  = modelMapper.map(gestionnaireRequestDto,GestionnaireDto.class);
        return gestionnaireDto;
    }

    public  GestionnaireResponseDto ToGestionnaireResponseDto(GestionnaireDto gestionnaireDto)
    {
        GestionnaireResponseDto gestionnaireResponseDto = modelMapper.map(gestionnaireDto,GestionnaireResponseDto.class);
        return gestionnaireResponseDto;
    }

}
