package br.com.wiflix.mapper;

import br.com.wiflix.dtos.CdzDTO;
import br.com.wiflix.entity.Cdz;
import org.springframework.stereotype.Component;

@Component
public class CDZMapper {

    public CdzDTO toDTO(Cdz cdz){
        return new CdzDTO(cdz.getUrl());
    }

    public Cdz toEntity(CdzDTO cdzDTO){
        Cdz cdz = new Cdz();
        cdz.setUrl(cdzDTO.url());
        return cdz;
    }

}
