package ma.atos.agency.mappers;

import ma.atos.agency.dto.AgencyDto;
import ma.atos.agency.entities.Agency;
import org.modelmapper.ModelMapper;

public class AgencyConverter {

    public static Agency toAgency(AgencyDto agencyDto)
    {
        Agency agency = new Agency();
        ModelMapper modelMapper = new ModelMapper();
        agency=modelMapper.map(agencyDto, Agency.class);
        return agency;
    }

    public static AgencyDto toAgencyDto(Agency agency)
    {
        AgencyDto agencyDto = new AgencyDto();
        ModelMapper modelMapper = new ModelMapper();
        agencyDto=modelMapper.map(agency,AgencyDto.class);
        return agencyDto;

    }
}
