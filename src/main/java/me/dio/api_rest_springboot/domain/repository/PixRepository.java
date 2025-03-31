package me.dio.api_rest_springboot.domain.repository;

import me.dio.api_rest_springboot.domain.model.Pix;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PixRepository extends JpaRepository<Pix, UUID>{

    List<Pix> findAllByUserId(UUID userId);
}