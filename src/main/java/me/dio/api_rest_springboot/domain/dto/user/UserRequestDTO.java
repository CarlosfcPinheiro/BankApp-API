package me.dio.api_rest_springboot.domain.dto.user;

import lombok.Getter;
import lombok.Setter;

import me.dio.api_rest_springboot.domain.model.Account;
import me.dio.api_rest_springboot.domain.model.Card;
import me.dio.api_rest_springboot.domain.model.Feature;
import me.dio.api_rest_springboot.domain.model.News;

import java.util.List;

@Getter
@Setter
public class UserRequestDTO {
    private String name;

    private Account account;

    private Card card;

    private List<Feature> features;

    private List<News> news;
}
