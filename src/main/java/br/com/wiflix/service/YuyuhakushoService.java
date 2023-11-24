package br.com.wiflix.service;

import br.com.wiflix.dtos.YuyuhakushoDTO;

import java.util.List;

public interface YuyuhakushoService {

    List<YuyuhakushoDTO> findAll();

    YuyuhakushoDTO post(YuyuhakushoDTO yuyuhakushoDTO);

    YuyuhakushoDTO getOne(Long id);

    YuyuhakushoDTO update(Long id, YuyuhakushoDTO yuyuhakushoDTO);

    void delete(Long id);

}
