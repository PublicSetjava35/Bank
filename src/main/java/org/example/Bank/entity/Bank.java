package org.example.Bank.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

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
    @Column(name = "timer")
    private LocalDateTime time;
    @OneToMany(mappedBy = "bank")
    private List<Account> accounts;
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