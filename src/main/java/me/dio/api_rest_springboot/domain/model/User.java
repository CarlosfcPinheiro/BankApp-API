package me.dio.api_rest_springboot.domain.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

// Auto generate Getter and Setter with lombok
@Getter
@Setter
// Jakarta/Hibernate annotation to entity identify
@Entity(name = "tb_user")
public class User {

    // Getter and Setters
    // id annotation identifier and GeneratedValue to Hibernate auto generation
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Feature> features;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<News> News;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Pix> pixList;
}