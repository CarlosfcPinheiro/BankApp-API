package me.dio.api_rest_springboot.domain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(){
        return "<h1>Bem-vindo a API BankApp!</h1>\n" +
                "<p>Acesse a documentação em /swagger-ui/index.html</p>";
    }

}
