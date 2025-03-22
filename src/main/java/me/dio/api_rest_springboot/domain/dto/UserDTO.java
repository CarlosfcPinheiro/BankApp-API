package me.dio.api_rest_springboot.domain.dto;

import lombok.Getter;
import lombok.Setter;

import me.dio.api_rest_springboot.domain.model.Account;
import me.dio.api_rest_springboot.domain.model.Card;

import java.util.UUID;

@Getter
@Setter
public class UserDTO {
    private UUID id;

    private String name;

    private Account account;

    private Card card;
}
