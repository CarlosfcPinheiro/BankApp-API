package me.dio.api_rest_springboot.domain.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import me.dio.api_rest_springboot.domain.enums.KeyTypeEnum;

import java.util.UUID;

@Setter
@Getter
@Entity(name = "tb_pix")
public class Pix {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private KeyTypeEnum keyType;

    @Column(nullable = false)
    private String key;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

}
