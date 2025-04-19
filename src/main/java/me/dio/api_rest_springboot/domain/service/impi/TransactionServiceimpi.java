package me.dio.api_rest_springboot.domain.service.impi;

import jakarta.transaction.Transactional;

import me.dio.api_rest_springboot.domain.model.User;
import me.dio.api_rest_springboot.domain.repository.UserRepository;
import me.dio.api_rest_springboot.domain.service.TransactionService;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class TransactionServiceimpi implements TransactionService {

    private final UserRepository userRepository;

    public TransactionServiceimpi(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional
    public void transfer(UUID userSenderId, UUID userReceiverId, BigDecimal amount){
        User sender = userRepository.findById(userSenderId).orElseThrow(NoSuchElementException::new);
        User receiver = userRepository.findById(userReceiverId).orElseThrow(NoSuchElementException::new);

        BigDecimal senderBalance = sender.getAccount().getBalance();
        BigDecimal receiverBalance = receiver.getAccount().getBalance();

        if (senderBalance.compareTo(receiverBalance) < 0){
            throw new RuntimeException("Not enough balance.");
        }

        sender.getAccount().setBalance(senderBalance.subtract(amount));
        receiver.getAccount().setBalance(receiverBalance.add(amount));
    }
}
