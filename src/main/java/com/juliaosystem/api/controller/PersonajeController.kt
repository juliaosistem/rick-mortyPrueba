package com.juliaosystem.api.controller

import com.common.lib.api.controller.CrudController
import com.common.lib.api.response.PlantillaResponse
import com.juliaosystem.api.dtos.PersonajesDTO
import com.juliaosystem.infraestructure.entitis.Character
import com.juliaosystem.infraestructure.services.primary.PersonajeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.NoSuchElementException

@RestController
@RequestMapping("/characters")
class PersonajeController(
    private  val personajeService: PersonajeService
) : CrudController<PersonajesDTO, PersonajesDTO, Character, Long> {

    override fun add(
        entidad: PersonajesDTO,
        id: Long?,
        ip: String,
        dominio: String,
        usuario: String,
        idBussines: Long,
        proceso: String
    ): ResponseEntity<PlantillaResponse<PersonajesDTO>> {
        val response = personajeService.add(entidad,id)
        return ResponseEntity(response, response.httpStatus)
    }
}
