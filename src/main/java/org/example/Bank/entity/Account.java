package org.example.Bank.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
@Setter
@Getter
@Entity
// Не используем аннотацию @Table, так как таблицы с именами совпадают.
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "time")
    private LocalDateTime time;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id")
    private Bank bank;
    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }
    /* Создаем без параметров, чтобы была возможность пользоваться без конфигураций */
    public Account() {}

    @PrePersist
    public void time() {
        this.time = LocalDateTime.now();
    }
}