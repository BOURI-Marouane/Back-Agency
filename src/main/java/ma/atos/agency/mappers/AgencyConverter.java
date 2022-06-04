package ma.atos.agency.mappers;

import ma.atos.agency.dto.AgencyDto;
import ma.atos.agency.dto.GestionnaireDto;
import ma.atos.agency.entities.Agency;
import ma.atos.agency.entities.Gestionnaire;
import ma.atos.agency.web.dto.Request.AgencyRequestDto;
import ma.atos.agency.web.dto.Request.GestionnaireRequestDto;
import ma.atos.agency.web.dto.Response.AgencyResponseDto;
import ma.atos.agency.web.dto.Response.GestionnaireResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;


@Configuration
public class AgencyConverter {


    @Autowired
    private ModelMapper modelMapper;

    public Agency toAgency(AgencyDto agencyDto) {
        Agency agency = modelMapper.map(agencyDto, Agency.class);
        return agency;
    }

    public AgencyDto toAgencyDto(Agency agency) {
        AgencyDto agencyDto = modelMapper.map(agency, AgencyDto.class);
        return agencyDto;

    }

    public AgencyDto ResquestToAgencyDto(AgencyRequestDto agencyRequestDto) {
        AgencyDto agencyDto = modelMapper.map(agencyRequestDto, AgencyDto.class);
        return agencyDto;
    }

    public AgencyResponseDto ToAgencyResponseDto(AgencyDto agencyDto) {
        AgencyResponseDto agencyResponseDto = modelMapper.map(agencyDto, AgencyResponseDto.class);
        return agencyResponseDto;
    }
}
