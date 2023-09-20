package br.com.wiflix.service;

import br.com.wiflix.dtos.CdzDTO;

import java.util.List;

public interface CdzService {

    List<CdzDTO> findAll();

    CdzDTO post(CdzDTO cdzDTO);

    CdzDTO getOne(Long id);

    CdzDTO update(Long id, CdzDTO cdzDTO);

    void delete(Long id);

}
