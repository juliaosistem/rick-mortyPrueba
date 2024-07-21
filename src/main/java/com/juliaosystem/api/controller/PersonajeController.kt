package com.juliaosystem.api.controller

import com.common.lib.api.controller.CrudController
import com.common.lib.api.response.PlantillaResponse
import com.juliaosystem.api.dtos.PersonajesDTO
import com.juliaosystem.infrastructure.entitis.Character
import com.juliaosystem.infrastructure.services.primary.PersonajeService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/characters")
@Tag(name = "personajes", description = "Endpoints relacionados con el manejo de Personajes de ricky ")
class PersonajeController(
    private  val personajeService: PersonajeService
) : CrudController<PersonajesDTO, PersonajesDTO, Character, Long> {

    @Operation(summary = "agregar personajes ", description = "permite agregar personajes  ")
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

    @Operation(summary = "obtener personajes", description = "permite obtener lista de libros con filtros por id ")
    override fun all(
        id: Long?,
        ip: String,
        dominio: String,
        usuario: String,
        idBussines: Long?,
        proceso: String
    ): ResponseEntity<PlantillaResponse<PersonajesDTO>> {
        val response = personajeService.all(id,idBussines)
        return ResponseEntity(response, response.httpStatus)
    }

    @Operation(summary = "Actualizar", description = "permite Actualizar personajes ")
    override fun update(
        entidad: PersonajesDTO,
        ip: String,
        dominio: String,
        usuario: String,
        idBussines: Long,
        proceso: String
    ): ResponseEntity<PlantillaResponse<PersonajesDTO>> {
        val response = personajeService.update(entidad)
        return ResponseEntity(response, response.httpStatus)
    }

    @Operation(summary = "Eliminar personaje", description = "permite eliminar Personajes ")
    override fun delete(
        id: Long,
        ip: String,
        dominio: String,
        usuario: String,
        idBussines: Long?,
        proceso: String
    ): ResponseEntity<PlantillaResponse<PersonajesDTO>> {
        val response = personajeService.delete(id)
        return ResponseEntity(response, response.httpStatus)
    }
}
