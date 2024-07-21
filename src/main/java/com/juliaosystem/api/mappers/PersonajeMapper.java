package com.juliaosystem.api.mappers;

import com.juliaosystem.api.dtos.PersonajesDTO;
import com.juliaosystem.infrastructure.entitis.Character;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel ="spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PersonajeMapper {

    PersonajesDTO getDto(Character source);

    Character getEntity(PersonajesDTO source);

    List<PersonajesDTO> getListDTO(List<Character> characters);
}
