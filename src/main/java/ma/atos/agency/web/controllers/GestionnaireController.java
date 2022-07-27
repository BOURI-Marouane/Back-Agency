package ma.atos.agency.web.controllers;

import ma.atos.agency.dto.GestionnaireDto;
import ma.atos.agency.exceptions.AgencyNotFoundException;
import ma.atos.agency.exceptions.ManagerNotFoundException;
import ma.atos.agency.mappers.GestionnaireConverter;
import ma.atos.agency.services.imp.GestionnaireService;
import ma.atos.agency.web.dto.Request.GestionnaireRequestDto;
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
@RequestMapping("/manager")
public class GestionnaireController {

    @Autowired
    private GestionnaireService gestionnaireService;

    @Autowired
    GestionnaireConverter gestionnaireConverter;


    @PostMapping("/save")
    public ResponseEntity<GestionnaireResponseDto> create(@Valid @RequestBody GestionnaireRequestDto gestionnaireRequestDto)
    {
        GestionnaireDto gestionnaireDto = null;
        GestionnaireResponseDto gestionnaireResponseDto = null;
        try {
            gestionnaireDto = gestionnaireService.newGestionnaire(gestionnaireRequestDto);
            gestionnaireResponseDto = gestionnaireConverter.ToGestionnaireResponseDto(gestionnaireDto);
            gestionnaireResponseDto.setHttpStatus(String.valueOf(HttpStatus.CREATED));
            gestionnaireResponseDto.setMessage("Entity is successful created");
            return ResponseEntity.ok().body(gestionnaireResponseDto);
        } catch (Exception e) {
            gestionnaireResponseDto.setHttpStatus(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            gestionnaireResponseDto.setMessage("Erreur technique est survenue. Veuillez contacter votre administrateur");
            return ResponseEntity.badRequest().body(gestionnaireResponseDto);
        }
    }

    @PostMapping("/findByCode")
    public GestionnaireResponseDto findByRegesterNumber(@RequestBody Long code) throws ManagerNotFoundException
    {
        try {
            return gestionnaireConverter.ToGestionnaireResponseDto(gestionnaireService.findByRegistrationNumber(code));
        }
        catch (Exception e)
        {
            throw new ManagerNotFoundException(code);
        }
    }

      @PostMapping("/all")
      public List<GestionnaireResponseDto> findAll()
      {

            List<GestionnaireDto> listDto = gestionnaireService.findAll();
            List<GestionnaireResponseDto> listResponseDto = new ArrayList<>();
            for(GestionnaireDto gestionnaireDto : listDto)
            {
                listResponseDto.add(gestionnaireConverter.ToGestionnaireResponseDto(gestionnaireDto));
            }
            return listResponseDto;
      }

      @PostMapping("/delete")
      public void delete(@RequestBody Long code) throws AgencyNotFoundException
      {
          try {
              gestionnaireService.delete(code);
          }
          catch (Exception e)
          {
              throw new AgencyNotFoundException("code");
          }
      }

      @PostMapping("/update")
      public ResponseEntity<GestionnaireResponseDto> update(@Valid @RequestBody GestionnaireRequestDto gestionnaireRequestDto) throws Exception
      {
          GestionnaireResponseDto gestionnaireResponseDto = null;
          GestionnaireDto gestionnaireDto=null;
            try {
                gestionnaireDto = gestionnaireService.updateGestnnaire(gestionnaireRequestDto,gestionnaireRequestDto.getRegistration_number());
                //gestionnaireDto = GestionnaireConverter.ResquestToGestionnaireDto(gestionnaireRequestDto);
                gestionnaireResponseDto = gestionnaireConverter.ToGestionnaireResponseDto(gestionnaireDto);
                //gestionnaireResponseDto.setHttpStatus(String.valueOf(HttpStatus.OK));
                //gestionnaireResponseDto.setMessage("Entity is successful modified");
                gestionnaireResponseDto.setHttpStatus(String.valueOf(HttpStatus.OK));
                gestionnaireResponseDto.setMessage("Entity is successful modified");
                return  ResponseEntity.ok().body(gestionnaireResponseDto);
            }catch (AgencyNotFoundException ex){
                throw  new AgencyNotFoundException("gestionnaireRequestDto.getAgency_id()");
            }
            catch (Exception e)
            {
                        gestionnaireResponseDto.setHttpStatus(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
                        gestionnaireResponseDto.setMessage("Erreur technique est survenue. Veuillez contactez votre administrateur");
                        return ResponseEntity.badRequest().body(gestionnaireResponseDto);
            }
      }









}
