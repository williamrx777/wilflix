package br.com.wiflix.mapper;

import br.com.wiflix.dtos.YuyuhakushoDTO;
import br.com.wiflix.entity.Yuyuhakusho;
import org.springframework.stereotype.Component;

@Component
public class YuyuhakushoMapper {

    public YuyuhakushoDTO toDTO(Yuyuhakusho yuyuhakusho){
        return new YuyuhakushoDTO(yuyuhakusho.getUrl());
    }

    public Yuyuhakusho toEntity(YuyuhakushoDTO yuyuhakushoDTO){
        var yuyuhakusho = new Yuyuhakusho();
        yuyuhakusho.setUrl(yuyuhakushoDTO.url());
        return yuyuhakusho;
    }

}
