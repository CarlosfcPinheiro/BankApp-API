package me.dio.api_rest_springboot.domain.controller;

import me.dio.api_rest_springboot.domain.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<String> transfer(@RequestParam UUID userSenderId, @RequestParam UUID userReceiverId, @RequestParam BigDecimal amount){
        transactionService.transfer(userSenderId, userReceiverId, amount);
        return ResponseEntity.ok("Transação efetuada com sucesso.");
    }
}
