package org.example.Bank.service;

import jakarta.validation.Valid;
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
    public void saveAccount(@Valid AccountDTO accountDTO) {
        // Создадим класс который, будет хешировать пароль
        repository.save(new Account(accountDTO.email(), accountDTO.password()));
    }
}