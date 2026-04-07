package org.example.Bank.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
// Не используем аннотацию @Table, так как таблицы с именами совпадают.
public class Bank {
    @Id
    // Задаем стратегию, Для авто генераций сущностей.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "balance")
    private Long balance;
    @Column(name = "timer_stamp")
    private LocalDateTime time;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;
    /* Создаем без параметров, чтобы была возможность пользоваться без конфигураций */
    public Bank(Long balance) {
        this.balance = balance;
    }
    public Bank() {}
    @PrePersist
    public void time() {
        this.time = LocalDateTime.now();
    }
}