package org.example.Bank.service;
import lombok.AllArgsConstructor;
import org.example.Bank.entity.Bank;
import org.example.Bank.repository.BankRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountBalanceService {
    private final BankRepository bankRepository;

    @Transactional(readOnly = true)
    public List<Long> getBalance(Long id) {
        Optional<Bank> balance = bankRepository.findById(id);
        return balance.stream().map(Bank::getBalance).toList();
    }
}