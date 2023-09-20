package br.com.wiflix.service.impl;

import br.com.wiflix.dtos.CdzDTO;
import br.com.wiflix.exception.RecordNotFoundException;
import br.com.wiflix.mapper.CDZMapper;
import br.com.wiflix.repositories.CdzRepository;
import br.com.wiflix.service.CdzService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CDZServiceImpl implements CdzService {

    private final CdzRepository cdzRepository;
    private final CDZMapper cdzMapper;
    public CDZServiceImpl(CdzRepository cdzRepository, CDZMapper cdzMapper) {
        this.cdzRepository = cdzRepository;
        this.cdzMapper = cdzMapper;
    }

    @Override
    public List<CdzDTO> findAll() {
        return cdzRepository.findAll().stream().map(cdzMapper::toDTO).toList();
    }

    @Override
    public CdzDTO post(CdzDTO cdzDTO) {
        return cdzMapper.toDTO(cdzRepository.save(cdzMapper.toEntity(cdzDTO)));
    }

    @Override
    public CdzDTO getOne(Long id) {
        return cdzRepository.findById(id).map(cdzMapper::toDTO).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @Override
    public CdzDTO update(Long id, CdzDTO cdzDTO) {
        return cdzRepository.findById(id)
                .map(c -> {
                    c.setUrl(cdzDTO.url());
                    return cdzMapper.toDTO(cdzRepository.save(c));
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @Override
    public void delete(Long id)  {
        cdzRepository.deleteById(id);
    }
}
