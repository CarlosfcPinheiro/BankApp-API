package me.dio.api_rest_springboot.domain.model;

import jakarta.persistence.Entity;
import me.dio.api_rest_springboot.domain.model.ext.BaseItem;

// Omitted Getter and Setter
@Entity(name = "tb_news")
public class News extends BaseItem { }