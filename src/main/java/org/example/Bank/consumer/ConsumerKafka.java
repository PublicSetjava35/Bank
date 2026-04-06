package org.example.Bank.consumer;
import lombok.AllArgsConstructor;
import org.example.Bank.dto.AccountDTO;
import org.example.Bank.dto.BankDTO;
import org.example.Bank.service.AccountService;
import org.example.Bank.service.BankService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class ConsumerKafka {
    private final AccountService accountService;
    private final BankService bankService;

    @KafkaListener(topics = "account-service", groupId = "group-id")
    public void saveAccount(AccountDTO dto) {
      // Сохраняем запись, в БД
      accountService.saveAccount(dto);
    }
    // Saving balanced in bank
    @KafkaListener(topics = "bank-service", groupId = "group-id")
    public void saveBalance(BankDTO bank) {
      bankService.saveBalance(bank);
    }
}