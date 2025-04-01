package me.dio.api_rest_springboot.domain.service.impi;

import me.dio.api_rest_springboot.domain.dto.pix.PixDTO;
import me.dio.api_rest_springboot.domain.dto.pix.PixResponseDTO;

import me.dio.api_rest_springboot.domain.mapper.PixMapper;

import me.dio.api_rest_springboot.domain.model.Pix;
import me.dio.api_rest_springboot.domain.model.User;

import me.dio.api_rest_springboot.domain.repository.PixRepository;
import me.dio.api_rest_springboot.domain.repository.UserRepository;

import me.dio.api_rest_springboot.domain.service.PixService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class PixServiceimpi implements PixService {

    private final PixRepository pixRepository;

    private final UserRepository userRepository;

    private final PixMapper pixMapper;

    public PixServiceimpi(PixRepository pixRepository, UserRepository userRepository, PixMapper pixMapper){
        this.pixRepository = pixRepository;
        this.userRepository = userRepository;
        this.pixMapper = pixMapper;
    }

    @Override
    public List<PixResponseDTO> findPixByUserId(UUID userId){
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        List<Pix> pixList = pixRepository.findAllByUserId(userId);

        List<PixResponseDTO> pixResponseDTOList = new ArrayList<>();
        pixList.forEach(pix -> {
            PixResponseDTO pixResponseDTO = pixMapper.toPixResponseDTO(pix);
            pixResponseDTOList.add(pixResponseDTO);
        });

        return pixResponseDTOList;
    }

    @Override
    public PixDTO create(PixDTO pixDTO){
        User user = userRepository.findById(pixDTO.getUserId()).orElseThrow(NoSuchElementException::new);
        Pix pixToCreate = pixMapper.toEntity(pixDTO, user);
        Pix savedPix = pixRepository.save(pixToCreate);
        return pixMapper.toPixDTO(savedPix);
    }
}