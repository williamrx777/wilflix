package br.com.wiflix.service;

import br.com.wiflix.dtos.ShuratoDTO;

import java.util.List;

public interface ShuratoService {

    List<ShuratoDTO> findAll();

    ShuratoDTO post(ShuratoDTO shuratoDTO);

    ShuratoDTO getOne(Long id);

    ShuratoDTO update(Long id ,ShuratoDTO shuratoDTO);

    void delete(Long id);

}
