package me.dio.api_rest_springboot.domain.model.ext;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String icon;

    private String description;
}
