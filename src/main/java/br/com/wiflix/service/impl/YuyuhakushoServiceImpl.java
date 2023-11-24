package br.com.wiflix.service.impl;

import br.com.wiflix.dtos.YuyuhakushoDTO;
import br.com.wiflix.exception.RecordNotFoundException;
import br.com.wiflix.mapper.YuyuhakushoMapper;
import br.com.wiflix.repositories.YuyuhakushoRepository;
import br.com.wiflix.service.YuyuhakushoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YuyuhakushoServiceImpl implements YuyuhakushoService {

    private final YuyuhakushoRepository yuyuhakushoRepository;
    private final YuyuhakushoMapper yuyuhakushoMapper;
    public YuyuhakushoServiceImpl(YuyuhakushoRepository yuyuhakushoRepository, YuyuhakushoMapper yuyuhakushoMapper) {
        this.yuyuhakushoRepository = yuyuhakushoRepository;
        this.yuyuhakushoMapper = yuyuhakushoMapper;
    }

    @Override
    public List<YuyuhakushoDTO> findAll() {
        return yuyuhakushoRepository.findAll().stream().map(yuyuhakushoMapper::toDTO).toList();
    }

    @Override
    public YuyuhakushoDTO post(YuyuhakushoDTO yuyuhakushoDTO) {
        return yuyuhakushoMapper.toDTO(yuyuhakushoRepository.save(yuyuhakushoMapper.toEntity(yuyuhakushoDTO)));
    }

    @Override
    public YuyuhakushoDTO getOne(Long id) {
        return yuyuhakushoRepository.findById(id).map(yuyuhakushoMapper::toDTO).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @Override
    public YuyuhakushoDTO update(Long id, YuyuhakushoDTO yuyuhakushoDTO) {
        return yuyuhakushoRepository.findById(id)
                .map(yuyuhakusho -> {
                    yuyuhakusho.setUrl(yuyuhakushoDTO.url());
                    return yuyuhakushoMapper.toDTO(yuyuhakushoRepository.save(yuyuhakusho));
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        yuyuhakushoRepository.deleteById(id);
    }
}
