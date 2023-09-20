package br.com.wiflix.service;

import br.com.wiflix.dtos.FilmeDTO;
import br.com.wiflix.repositories.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


public interface FilmeService {

  List<FilmeDTO> findAll();

  FilmeDTO post(FilmeDTO filmeDTO);

  FilmeDTO getOne(String id);

  FilmeDTO update(String id, FilmeDTO filmeDTO);

  void delete(String id);

}
