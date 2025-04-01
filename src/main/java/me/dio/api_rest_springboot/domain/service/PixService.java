package me.dio.api_rest_springboot.domain.service;

import me.dio.api_rest_springboot.domain.dto.pix.PixDTO;
import me.dio.api_rest_springboot.domain.dto.pix.PixResponseDTO;

import java.util.List;
import java.util.UUID;

public interface PixService {

    List<PixResponseDTO> findPixByUserId(UUID userId);

    PixDTO create(PixDTO pixDTO);
}
