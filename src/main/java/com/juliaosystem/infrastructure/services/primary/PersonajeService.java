package com.juliaosystem.infrastructure.services.primary;

import com.common.lib.api.response.PlantillaResponse;
import com.juliaosystem.api.dtos.PersonajesDTO;
import com.juliaosystem.infrastructure.adapters.primary.PersonajeImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonajeService {

    private final PersonajeImpl personajeImpl;


    public PlantillaResponse<PersonajesDTO> add(PersonajesDTO libroDTO, Long id) {
        return personajeImpl.add(libroDTO,id);
    }

    public PlantillaResponse<PersonajesDTO> all(Long id, Long idBussines) {
        return personajeImpl.all(id,idBussines);
    }


    public PlantillaResponse<PersonajesDTO> update(PersonajesDTO personajesDTO) {
        return personajeImpl.update(personajesDTO);
    }


    public PlantillaResponse<PersonajesDTO> delete(Long id) {
        return personajeImpl.delete(id);
    }

}
