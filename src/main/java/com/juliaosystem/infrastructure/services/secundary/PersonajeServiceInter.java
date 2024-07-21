package com.juliaosystem.infrastructure.services.secundary;

import com.common.lib.infraestructure.services.secundary.CrudSecundaryService;
import com.juliaosystem.api.dtos.PersonajesDTO;
import org.springframework.stereotype.Service;

@Service
public interface PersonajeServiceInter extends CrudSecundaryService<PersonajesDTO,PersonajesDTO,Long> {
}
