package ma.atos.agency.mappers;

import ma.atos.agency.dto.AgencyDto;
import ma.atos.agency.entities.Agency;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AgencyConverter {

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
}
