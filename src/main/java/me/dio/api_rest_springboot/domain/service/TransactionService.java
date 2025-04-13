package me.dio.api_rest_springboot.domain.service;

import java.math.BigDecimal;
import java.util.UUID;

public interface TransactionService {
    void transfer(UUID userSenderId, UUID userReceiverId, BigDecimal amount);
}
