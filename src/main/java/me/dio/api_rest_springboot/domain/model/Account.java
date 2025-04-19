package me.dio.api_rest_springboot.domain.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String number;

    private String agency;

    @Column(precision = 13, scale = 2)
    private BigDecimal balance;

    @Column(name = "additional_limit", precision = 13, scale = 2)
    private BigDecimal limit;
}
