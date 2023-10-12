package br.com.wiflix.mapper;

import br.com.wiflix.dtos.SWDTO;
import br.com.wiflix.entity.SW;
import org.springframework.stereotype.Component;

@Component
public class SWMapper {

    public SWDTO toDTO(SW sw){
        return new SWDTO(sw.getUrl());
    }

    public SW toEntity(SWDTO swdto){
        SW sw = new SW();
        sw.setUrl(swdto.url());
        return sw;
    }

}
