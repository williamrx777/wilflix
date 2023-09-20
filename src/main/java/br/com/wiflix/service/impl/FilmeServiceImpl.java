package br.com.wiflix.service.impl;

import br.com.wiflix.dtos.FilmeDTO;
import br.com.wiflix.exception.FilmeNotFoundException;
import br.com.wiflix.mapper.FilmeMapper;
import br.com.wiflix.repositories.FilmeRepository;
import br.com.wiflix.service.FilmeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeServiceImpl implements FilmeService {

    private final FilmeRepository filmeRepository;
    private final FilmeMapper filmeMapper;
    public FilmeServiceImpl(FilmeRepository filmeRepository, FilmeMapper filmeMapper) {
        this.filmeRepository = filmeRepository;
        this.filmeMapper = filmeMapper;
    }



    @Override
    public List<FilmeDTO> findAll() {
        return filmeRepository.findAll().stream().map(filmeMapper::toDTO).toList();
    }

    @Override
    public FilmeDTO post(FilmeDTO filmeDTO) {
        return filmeMapper.toDTO(filmeRepository.save(filmeMapper.toEntity(filmeDTO)));
    }

    @Override
    public FilmeDTO getOne(String id) {
        return filmeRepository.findById(id).map(filmeMapper::toDTO).orElseThrow(() -> new FilmeNotFoundException(id));
    }

    @Override
    public FilmeDTO update(String id, FilmeDTO filmeDTO) {
        return filmeRepository.findById(id)
                .map(f -> {
                    f.setNome(filmeDTO.nome());
                    f.setUrl(filmeDTO.url());
                    return filmeMapper.toDTO(filmeRepository.save(f));
                }).orElseThrow(() -> new FilmeNotFoundException(id));
    }

    @Override
    public void delete(String id) {
        filmeRepository.deleteById(id);
    }
}
