package br.com.wiflix.mapper;

import br.com.wiflix.dtos.FilmeDTO;
import br.com.wiflix.entity.Filme;
import org.springframework.stereotype.Component;

@Component
public class FilmeMapper {

    public FilmeDTO toDTO(Filme filme){
        return new FilmeDTO(filme.getId(), filme.getNome(), filme.getUrl());
    }


    public Filme toEntity(FilmeDTO filmeDTO){
        Filme filme = new Filme();
        filme.setId(filmeDTO.id());
        filme.setNome(filmeDTO.nome());
        filme.setUrl(filmeDTO.url());
        return filme;
    }

}
