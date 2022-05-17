package ma.atos.agency.mappers;

import ma.atos.agency.dto.AgencyDto;
import ma.atos.agency.entities.Agency;
import ma.atos.agency.web.dto.Request.AgencyRequestDto;
import ma.atos.agency.web.dto.Response.AgencyResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;


@Configuration
public class AgencyConverter {

//hello world
    @Autowired
    private ModelMapper modelMapper;
    public Agency toAgency(AgencyDto agencyDto)
    {
        Agency agency = modelMapper.map(agencyDto, Agency.class);
        return agency;
    }

    public  AgencyDto toAgencyDto(Agency agency)
    {
        AgencyDto agencyDto = modelMapper.map(agency,AgencyDto.class);
        return agencyDto;

    }

    public AgencyDto RequestToAgencyDto(AgencyRequestDto agencyRequestDto)
    {
        AgencyDto agencyDto = modelMapper.map(agencyRequestDto,AgencyDto.class);


    @Autowired
    ModelMapper modelMapper;

    public Agency toAgency(AgencyDto agencyDto)
    {
        Agency agency = new Agency();
        agency=modelMapper.map(agencyDto, Agency.class);
        return agency;
    }

    public AgencyDto toAgencyDto(Agency agency)
    {
        AgencyDto agencyDto = new AgencyDto();
        agencyDto=modelMapper.map(agency,AgencyDto.class);

        return agencyDto;
    }

    public AgencyResponseDto ToResponseAgencyDto(AgencyDto agencyDto)
    {
        AgencyResponseDto agencyResponseDto = modelMapper.map(agencyDto,AgencyResponseDto.class);
        return agencyResponseDto;
    }
}
