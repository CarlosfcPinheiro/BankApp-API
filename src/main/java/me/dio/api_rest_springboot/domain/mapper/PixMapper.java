package me.dio.api_rest_springboot.domain.mapper;

import me.dio.api_rest_springboot.domain.dto.pix.PixDTO;
import me.dio.api_rest_springboot.domain.dto.pix.PixResponseDTO;

import me.dio.api_rest_springboot.domain.model.Pix;
import me.dio.api_rest_springboot.domain.model.User;

import org.springframework.stereotype.Component;

@Component
public class PixMapper {
    public PixDTO toPixDTO(Pix pix){
        PixDTO pixDTO = new PixDTO();
        pixDTO.setId(pix.getId());
        pixDTO.setKeyType(pix.getKeyType());
        pixDTO.setKey(pix.getKey());
        pixDTO.setUserId(pix.getUser().getId());

        return pixDTO;
    }

    public PixResponseDTO toPixResponseDTO(Pix pix){
        PixResponseDTO pixResponseDTO = new PixResponseDTO();
        pixResponseDTO.setId(pix.getId());
        pixResponseDTO.setKeyType(pix.getKeyType());
        pixResponseDTO.setKey(pix.getKey());

        return pixResponseDTO;
    }

    public Pix toEntity(PixDTO pixDTO, User user){
        Pix pix = new Pix();
        pix.setId(pixDTO.getId());
        pix.setKeyType(pixDTO.getKeyType());
        pix.setKey(pixDTO.getKey());
        pix.setUser(user);

        return pix;
    }
}
