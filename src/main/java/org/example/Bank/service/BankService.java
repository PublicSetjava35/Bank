package org.example.Bank.service;

import lombok.AllArgsConstructor;
import org.example.Bank.dto.BankDTO;
import org.example.Bank.entity.Bank;
import org.example.Bank.repository.AccountRepository;
import org.example.Bank.repository.BankRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class BankService {
   private final AccountRepository accountRepository;
   private final BankRepository repository;
   /* Обрабатываем любое исключение, которая попадет в обертку (PROXY) */
   @Transactional(rollbackFor = Exception.class)
   // Создаем запись, в базу данных.
   public void saveBalance(BankDTO bankDTO) {
       if(bankDTO.balance() != null && bankDTO.balance() == 0x0) {
           throw new IllegalArgumentException("Invalid balance");
       }
       repository.save(new Bank(bankDTO.balance()));
   }
}