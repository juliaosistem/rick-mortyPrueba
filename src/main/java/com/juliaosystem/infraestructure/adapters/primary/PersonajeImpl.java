package com.juliaosystem.infraestructure.adapters.primary;

import com.common.lib.api.response.PlantillaResponse;
import com.common.lib.infraestructure.services.primary.CrudPrimaryService;
import com.juliaosystem.api.dtos.PersonajesDTO;
import com.juliaosystem.infraestructure.services.secundary.PersonajeServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonajeImpl  implements CrudPrimaryService<PersonajesDTO,PersonajesDTO,Long> {

 private final PersonajeServiceInter personajeServiceInter;

    @Override
    public PlantillaResponse<PersonajesDTO> add(PersonajesDTO e, Long id) {
        return CrudPrimaryService.super.add(e, id);
    }
}
