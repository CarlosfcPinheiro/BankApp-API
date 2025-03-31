package me.dio.api_rest_springboot.domain.dto.pix;

import lombok.Getter;
import lombok.Setter;

import me.dio.api_rest_springboot.domain.enums.KeyTypeEnum;

import java.util.UUID;

@Getter
@Setter
public class PixDTO {
    private UUID id;

    private KeyTypeEnum keyType;

    private String key;

    private UUID userId;
}
