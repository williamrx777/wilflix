package br.com.wiflix.service.impl;

import br.com.wiflix.dtos.SWDTO;
import br.com.wiflix.exception.RecordNotFoundException;
import br.com.wiflix.mapper.SWMapper;
import br.com.wiflix.repositories.SWRepository;
import br.com.wiflix.service.SWService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SWServiceImpl implements SWService {

    private final SWRepository swRepository;
    private final SWMapper swMapper;
    public SWServiceImpl(SWRepository swRepository, SWMapper swMapper) {
        this.swRepository = swRepository;
        this.swMapper = swMapper;
    }

    @Override
    public List<SWDTO> findAll() {
        return swRepository.findAll().stream().map(swMapper::toDTO).toList();
    }

    @Override
    public SWDTO post(SWDTO swdto) {
        return swMapper.toDTO(swRepository.save(swMapper.toEntity(swdto)));
    }

    @Override
    public SWDTO getOne(Long id) {
        return swRepository.findById(id).map(swMapper::toDTO).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @Override
    public SWDTO atualizar(Long id, SWDTO swdto) {
        return swRepository.findById(id)
                .map(s -> {
                    s.setUrl(swdto.url());
                    return swMapper.toDTO(swRepository.save(s));
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @Override
    public void delete(Long id) {

    }
}
