package com.juliaosystem.infrastructure.adapters.secundary;


import com.common.lib.api.response.PlantillaResponse;
import com.common.lib.utils.UserResponses;
import com.common.lib.utils.enums.MensajesRespuesta;
import com.common.lib.utils.enums.ResponseType;
import com.common.lib.utils.errors.AbtractError;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.juliaosystem.api.dtos.PersonajesDTO;
import com.juliaosystem.api.mappers.PersonajeMapper;
import com.juliaosystem.infrastructure.repository.CharacterRepository;
import com.juliaosystem.infrastructure.services.secundary.PersonajeServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PersonajeAdapter implements PersonajeServiceInter {

    private static final ObjectMapper OBJECT_MAPPER =
            new ObjectMapper().registerModule(new JavaTimeModule());
    private final AbtractError abtractError;

    private final CharacterRepository  characterRepository;
    private final UserResponses<PersonajesDTO> userResponses;
    private final PersonajeMapper mapper;


    @Override
    public PlantillaResponse<PersonajesDTO> add(PersonajesDTO personajesDTO) {

        try {
            var  res = mapper.getDto(characterRepository.save(mapper.getEntity(personajesDTO)));
            abtractError.logInfo("LibroAdapter.add():" + MensajesRespuesta.CREADO +     OBJECT_MAPPER.writeValueAsString(res));
            return userResponses.buildResponse(ResponseType.CREATED.getCode(), res);

        }catch (Exception e){
            abtractError.logError(e);
            return   userResponses.buildResponse(ResponseType.FALLO.getCode(), PersonajesDTO.builder().build());
        }
    }

    @Override
    public PlantillaResponse<PersonajesDTO> byId(Long id) {
        try {
            var characters = characterRepository.findById(id);
            if(characters.isEmpty()){
                abtractError.logInfo("PersonajeAdapter.byId():" + MensajesRespuesta.NO_ENCONTRADO +  OBJECT_MAPPER.writeValueAsString(id));
                return userResponses.buildResponse(ResponseType.NO_ENCONTRADO.getCode(), PersonajesDTO.builder().build());
            }else {
                var listDTO = mapper.getDto(characters.get());
                abtractError.logInfo("PersonajeAdapter.byId()" + MensajesRespuesta.GET +     OBJECT_MAPPER.writeValueAsString(listDTO));
                return userResponses.buildResponse(ResponseType.GET.getCode(), listDTO);
            }
        }catch (Exception e){
            abtractError.logError(e);
            return   userResponses.buildResponse(ResponseType.FALLO.getCode(), PersonajesDTO.builder().build());
        }
    }

    @Override
    public PlantillaResponse<PersonajesDTO> all() {
        try {
            var listUsers = characterRepository.findAll();
            if(listUsers.isEmpty()){
                abtractError.logInfo("PersonajeAdapter.all():" + MensajesRespuesta.NO_ENCONTRADO +  OBJECT_MAPPER.writeValueAsString(listUsers));
                return userResponses.buildResponse(ResponseType.NO_ENCONTRADO.getCode(), PersonajesDTO.builder().build());
            }else {
                var listDTO = mapper.getListDTO(listUsers);
                abtractError.logInfo("PersonajeAdapter.all():" + MensajesRespuesta.GET);
                return userResponses.buildResponse(ResponseType.GET.getCode(), PersonajesDTO.builder().build(),listDTO);
            }
        }catch (Exception e){
            abtractError.logError(e);
            return   userResponses.buildResponse(ResponseType.FALLO.getCode(), PersonajesDTO.builder().build());
        }
    }



    @Override
    public PlantillaResponse<PersonajesDTO> delete(Long id) {
        try {
            characterRepository.deleteById(id);
            abtractError.logInfo("PersonajeAdapter.delete():" + MensajesRespuesta.DELETED +     OBJECT_MAPPER.writeValueAsString(id));
            return userResponses.buildResponse(ResponseType.DELETED.getCode(), PersonajesDTO.builder().id(id).build());

        }catch (Exception e){
            abtractError.logError(e);
            return   userResponses.buildResponse(ResponseType.FALLO.getCode(), PersonajesDTO.builder().build());
        }
    }
}


