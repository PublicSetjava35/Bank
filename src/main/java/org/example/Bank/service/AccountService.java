package org.example.Bank.service;

import lombok.AllArgsConstructor;
import org.example.Bank.dto.AccountDTO;
import org.example.Bank.entity.Account;
import org.example.Bank.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AccountService {
    private final AccountRepository repository;
    @Transactional(rollbackFor = Exception.class)
    public void saveAccount(AccountDTO accountDTO) {
        if(accountDTO.email() != null && accountDTO.password().isBlank()) {
            throw new IllegalArgumentException("Invalid email");
        } else if (accountDTO.password() != null && accountDTO.password().isBlank()) {
            throw new IllegalArgumentException("Invalid password");
        }
        if(repository.existsByEmail(accountDTO.email())) {
            throw new IllegalArgumentException("Email is duplicated!!");
        }
        // Создадим класс который, будет хешировать пароль
        repository.save(new Account(accountDTO.email(), accountDTO.password()));
    }
}