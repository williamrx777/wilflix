package br.com.wiflix.mapper;

import br.com.wiflix.dtos.ShuratoDTO;
import br.com.wiflix.entity.Shurato;
import org.springframework.stereotype.Component;

@Component
public class ShuratoMapper {

    public ShuratoDTO toDTO(Shurato shurato){
        return new ShuratoDTO(shurato.getUrl());
    }

    public Shurato toEntity(ShuratoDTO shuratoDTO){
        var shurato = new Shurato();
        shurato.setUrl(shuratoDTO.url());
        return shurato;
    }

}
