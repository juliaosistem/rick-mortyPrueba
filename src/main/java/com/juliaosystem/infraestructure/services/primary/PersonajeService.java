package com.juliaosystem.infraestructure.services.primary;

import com.common.lib.api.response.PlantillaResponse;
import com.common.lib.infraestructure.services.primary.CrudPrimaryService;
import com.juliaosystem.api.dtos.PersonajesDTO;
import com.juliaosystem.infraestructure.adapters.primary.PersonajeImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonajeService implements CrudPrimaryService<PersonajesDTO,PersonajesDTO,Long> {

    private final PersonajeImpl personajeImpl;

    @Override
    public PlantillaResponse<PersonajesDTO> add(PersonajesDTO personajesDTO, Long id) {
        return personajeImpl.add(personajesDTO, id);
    }
}
