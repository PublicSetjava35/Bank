package org.example.Bank.repository;

import lombok.NonNull;
import org.example.Bank.entity.Bank;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
    @Override
    @NonNull
    @EntityGraph(attributePaths = {"account"})
    Optional<Bank> findById(@NonNull Long aLong);
}