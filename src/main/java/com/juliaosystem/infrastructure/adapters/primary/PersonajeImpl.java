package com.juliaosystem.infrastructure.adapters.primary;

import com.common.lib.api.response.PlantillaResponse;
import com.common.lib.infraestructure.services.primary.CrudPrimaryService;
import com.common.lib.utils.enums.MensajesRespuesta;
import com.juliaosystem.api.dtos.PersonajesDTO;
import com.juliaosystem.infrastructure.services.secundary.PersonajeServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PersonajeImpl implements CrudPrimaryService<PersonajesDTO,PersonajesDTO,Long> {

    private final PersonajeServiceInter personajeServiceInter;



    @Override
    public  PlantillaResponse<PersonajesDTO> add(PersonajesDTO libroDTO , Long id){
        var res  = personajeServiceInter.byId(id);
        if(res.isRta()) return res;
        else return  personajeServiceInter.add(libroDTO);
    }

    @Override
    public PlantillaResponse<PersonajesDTO> delete(Long id) {
        var res  = personajeServiceInter.byId(id);
        if(res.isRta()) return  personajeServiceInter.delete(id);
        else return res;
    }

    @Override
    public PlantillaResponse<PersonajesDTO> all (Long id, Long idBussines) {

        if(id  == null) {
            if(idBussines == null)
                return personajeServiceInter.all();
            else
                return personajeServiceInter.byIdBussines(idBussines);
        }else
            return personajeServiceInter.byId(id);
    }

    @Override
    public PlantillaResponse<PersonajesDTO> update(PersonajesDTO libroDTO) {
        var response = personajeServiceInter.byId(libroDTO.getId());
        if (response.isRta()) {
            response = personajeServiceInter.add(libroDTO);
            response.setMessage(MensajesRespuesta.ACTUALIZADO.getMensaje());
            return response;
        }
        else {
            return response;
        }
    }


}
