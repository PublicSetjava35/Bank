package org.example.Bank.repository;

import jakarta.annotation.Nonnull;
import org.example.Bank.entity.Account;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Override
    @Nonnull
    @EntityGraph(attributePaths = {"bank"})
    Optional<Account> findById(@Nonnull Long aLong);
    boolean existsByEmail(String email);
}
