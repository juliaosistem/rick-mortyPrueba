package com.juliaosystem.infrastructure.adapters.secundary

import com.common.lib.api.mappers.GenericMapper
import com.common.lib.api.response.PlantillaResponse
import com.common.lib.utils.UserResponses
import com.common.lib.utils.enums.ResponseType
import com.common.lib.utils.errors.AbtractError
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
abstract class DefaultAdapter<RES, RQ, E, I>(
    private val mapper: GenericMapper<RES, RQ, E>,
    private val abstractError: AbtractError,
    private val userResponses: UserResponses<RES>,
    private val resClass: RES, // Usar Class en lugar de instancia
    private val entityClass: E, // Usar Class en lugar de instancia
    private val  defaultRepository :CrudRepository<E, I>
) {

    fun all(): PlantillaResponse<RES> {
        return try {
            val response = mapper.mapListToRes(defaultRepository.findAll().toList(), resClass)
            if (response.isEmpty()) {
                abstractError.logInfo("res.all() :  ${ResponseType.GET.message} ")
                userResponses.buildResponse(ResponseType.NO_ENCONTRADO.code, response.firstOrNull())
            } else {
                abstractError.logInfo("DefaultAdapter.all() :  ${ResponseType.GET.message} - de auditoria")
                userResponses.buildResponse(ResponseType.GET.code, response.firstOrNull(), response)
            }
        } catch (e: Exception) {
            abstractError.logError(e)
            userResponses.buildResponse(ResponseType.FALLO.code, null)
        }
    }

    fun byId(id: I): PlantillaResponse<RES> {
        return try {
            val response = defaultRepository.findById(id!!)
            if (response.isPresent) {
                abstractError.logInfo("DefaultAdapter.byId() :  ${ResponseType.GET.message}")
                userResponses.buildResponse(ResponseType.GET.code, mapper.mapToRes(response.get(), resClass))
            } else {
                abstractError.logInfo("DefaultAdapter.byId() :  ${ResponseType.NO_ENCONTRADO.message}")
                userResponses.buildResponse(ResponseType.NO_ENCONTRADO.code, null)
            }
        } catch (e: Exception) {
            abstractError.logError(e)
            userResponses.buildResponse(ResponseType.FALLO.code, null)
        }
    }

    fun delete(id: I): PlantillaResponse<RES> {
        return try {
            defaultRepository.deleteById(id!!)
            userResponses.buildResponse(ResponseType.DELETED.code, null)
        } catch (e: Exception) {
            abstractError.logError(e)
            userResponses.buildResponse(ResponseType.FALLO.code, null)
        }
    }

    fun add(request: RQ): PlantillaResponse<RES> {
        return try {
            val entity = mapper.mapToEntity(request, entityClass)
            val savedEntity = defaultRepository.save(entity)
            val response = mapper.mapToRes(savedEntity, resClass)
            abstractError.logInfo("DefaultAdapter.add() :   ${ResponseType.CREATED.message}")
            userResponses.buildResponse(ResponseType.CREATED.code, response)
        } catch (e: Exception) {
            abstractError.logError(e)
            userResponses.buildResponse(ResponseType.FALLO.code, null)
        }
    }
}
