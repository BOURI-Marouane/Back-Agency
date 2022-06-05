package ma.atos.agency.web.controllers;

import ma.atos.agency.constantes.ConstanteAgency;
import ma.atos.agency.dto.AgencyDto;
import ma.atos.agency.dto.AgencyTermined;
import ma.atos.agency.dto.GestionnaireDto;
import ma.atos.agency.dto.GetAgencyCode;
import ma.atos.agency.entities.Agency;
import ma.atos.agency.exceptions.AgencyFussioneNotFound;
import ma.atos.agency.exceptions.AgencyNotFoundException;
import ma.atos.agency.exceptions.ExceptionFussione;
import ma.atos.agency.mappers.AgencyConverter;
import ma.atos.agency.services.imp.AgencyService;
import ma.atos.agency.web.dto.GeneraleDtoResponse;
import ma.atos.agency.web.dto.Request.AgencyRequestDto;
import ma.atos.agency.web.dto.Response.AgencyResponseDto;
import ma.atos.agency.web.dto.Response.GestionnaireResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/agency")
public class AgenceController {

    @Autowired
    private AgencyService agencyService;

    @Autowired
    AgencyConverter agencyConverter;

    @PostMapping("/save")
    private AgencyResponseDto createAgency(@Valid @RequestBody AgencyRequestDto agencyRequestDto)
    {
        AgencyResponseDto agencyResponseDto = null;
        try {

            agencyResponseDto = agencyConverter.ToAgencyResponseDto(agencyService.newAgency(agencyConverter.ResquestToAgencyDto(agencyRequestDto)));
            agencyResponseDto.setHttpStatus("200 ");
            agencyResponseDto.setMessage("succès de la requête");

        }
        catch (Exception e)
        {
            agencyResponseDto.setHttpStatus("500");
            agencyResponseDto.setMessage("erreurs serveur");
        }
        return agencyResponseDto;
    }



    @PostMapping("/findByCode")
    private AgencyResponseDto findByCode(@RequestBody GetAgencyCode getAgencyCode) throws Exception
    {
        AgencyResponseDto result = new AgencyResponseDto();
        try
        {
            result = agencyConverter.ToAgencyResponseDto(agencyService.findByCode(getAgencyCode.getCode()));
            result.setHttpStatus("200");
            result.setMessage("succès de la requêt");
        }
        catch (AgencyNotFoundException ex)
        {
            result.setHttpStatus("404");
            result.setMessage(ConstanteAgency.AGENCY_NOT_FOUND);
        }
        catch (Exception e)
        {
            result.setHttpStatus("500");
            result.setMessage("erreurs serveur");

        }
        return result;
    }

 /*   @PostMapping("/fussione")
    private AgencyResponseDto fussione(@RequestBody AgencyTermined agencyTermined)
    {
        AgencyResponseDto result = new AgencyResponseDto();
        try {
            result = agencyConverter.ToAgencyResponseDto(agencyService.fussione(agencyTermined.getCode_A(), agencyTermined.getCode_B()));
            result.setHttpStatus("200");
            result.setMessage("succès de la requêt");
        }
        catch (AgencyFussioneNotFound ex)
        {
            result.setHttpStatus("404");
            result.setMessage(ConstanteAgency.AGENCY_NOT_FOUND);
        }
        catch (Exception e)
        {

            result.setHttpStatus("500");
            result.setMessage("erreurs serveur");
        }
    }*/

    @PostMapping("/fussione")
    private AgencyResponseDto fussione(@RequestBody AgencyTermined agencyTermined) throws Exception
    {
        AgencyResponseDto result = new AgencyResponseDto();
        //AgencyResponseDto result1 = new AgencyResponseDto();
        try
        {
            result = agencyConverter.ToAgencyResponseDto(agencyService.fussione(agencyTermined.getCode_A(), agencyTermined.getCode_B()));
            //result1 = agencyConverter.ToAgencyResponseDto(agencyService.findByCode(agencyTermined.getCode_A()));
            result.setHttpStatus("200");
            result.setMessage("succès de la requêt");
        }
        catch (Exception e)
        {
            result.setHttpStatus("404");
            result.setMessage(ConstanteAgency.FUSS_NOT_FOUND);

        }
        return result;
    }

  @RequestMapping("/delete")
    private GeneraleDtoResponse delete(@RequestBody GetAgencyCode getAgencyCode) throws Exception
    {
        GeneraleDtoResponse result = new GeneraleDtoResponse();
        try {
            result = agencyConverter.ToGeneraleResponseDto(agencyService.findByCode(getAgencyCode.getCode()));
            agencyService.delete(getAgencyCode.getCode());
            result.setHttpStatus("200");
            result.setMessage("succès de la requêt");
        }
        catch (AgencyNotFoundException ex)
        {
            result.setHttpStatus("404");
            result.setMessage(ConstanteAgency.AGENCY_NOT_FOUND);
        }
        catch (Exception e)
        {
            result.setHttpStatus("500");
            result.setMessage("erreurs serveur");
        }
        return result;
    }

    @PostMapping("/update")
    private AgencyResponseDto update(@Valid @RequestBody AgencyRequestDto agencyRequestDto) throws Exception {
        AgencyResponseDto result = new AgencyResponseDto();
      try {
          result = agencyConverter.ToAgencyResponseDto(agencyService.update(agencyConverter.ResquestToAgencyDto(agencyRequestDto)));
          result.setHttpStatus("200");
          result.setMessage("succès de la requêt");
      }
      catch (AgencyNotFoundException ex)
      {
          result.setHttpStatus("404");
          result.setMessage(ConstanteAgency.AGENCY_NOT_FOUND);
      }
      catch (Exception e)
      {
          result.setHttpStatus("500");
          result.setMessage("erreurs serveur");

      }

    return result;
    }


    @PostMapping("/all")
    public List<AgencyResponseDto> findAll()
    {
        GeneraleDtoResponse result = new GeneraleDtoResponse();
        try {
            List<AgencyDto> listDto = agencyService.findAll();
            List<AgencyResponseDto> listResponseDto = new ArrayList<>();
            for(AgencyDto agencyDto : listDto)
            {
                listResponseDto.add(agencyConverter.ToAgencyResponseDto(agencyDto));
            }
            return listResponseDto;
        } catch (Exception e)
        {
            result.setHttpStatus("500");
            result.setMessage("erreurs serveur");

            return (List<AgencyResponseDto>) result;
        }

    }


}
