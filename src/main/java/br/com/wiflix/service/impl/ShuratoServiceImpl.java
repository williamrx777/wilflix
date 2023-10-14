package br.com.wiflix.service.impl;

import br.com.wiflix.dtos.ShuratoDTO;
import br.com.wiflix.exception.RecordNotFoundException;
import br.com.wiflix.mapper.ShuratoMapper;
import br.com.wiflix.repositories.ShuratoRepository;
import br.com.wiflix.service.ShuratoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShuratoServiceImpl implements ShuratoService {

    private final ShuratoRepository shuratoRepository;
    private final ShuratoMapper shuratoMapper;

    public ShuratoServiceImpl(ShuratoRepository shuratoRepository, ShuratoMapper shuratoMapper) {
        this.shuratoRepository = shuratoRepository;
        this.shuratoMapper = shuratoMapper;
    }

    @Override
    public List<ShuratoDTO> findAll() {
        return shuratoRepository.findAll().stream().map(shuratoMapper::toDTO).toList();
    }

    @Override
    public ShuratoDTO post(ShuratoDTO shuratoDTO) {
        return shuratoMapper.toDTO(shuratoRepository.save(shuratoMapper.toEntity(shuratoDTO)));
    }

    @Override
    public ShuratoDTO getOne(Long id) {
        return shuratoRepository.findById(id).map(shuratoMapper::toDTO).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @Override
    public ShuratoDTO update(Long id ,ShuratoDTO shuratoDTO) {
        return shuratoRepository.findById(id)
                .map(shurato -> {
                    shurato.setUrl(shuratoDTO.url());
                    return shuratoMapper.toDTO(shuratoRepository.save(shurato));
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        shuratoRepository.deleteById(id);
    }
}
