package br.com.wiflix.service;

import br.com.wiflix.dtos.SWDTO;

import java.util.List;

public interface SWService {

    List<SWDTO> findAll();

    SWDTO post(SWDTO swdto);

    SWDTO getOne(Long id);

    SWDTO atualizar(Long id, SWDTO swdto);

    void delete(Long id);
}
