package me.dio.api_rest_springboot.domain.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "tb_card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String number;

    @Column(name = "available_limit", precision = 13, scale = 2)
    private BigDecimal limit;
}
