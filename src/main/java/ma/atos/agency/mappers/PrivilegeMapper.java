package ma.atos.agency.mappers;

import ma.atos.agency.dto.PrivilegeDto;
import ma.atos.agency.entities.Privilege;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrivilegeMapper {
    @Autowired
    ModelMapper modelMapper;

    public Privilege MaptoEntity(PrivilegeDto privilegeDto){
        return modelMapper.map(privilegeDto,Privilege.class);
    }

    public PrivilegeDto MaptoDto(Privilege privilege){
        return modelMapper.map(privilege,PrivilegeDto.class);
    }




}
