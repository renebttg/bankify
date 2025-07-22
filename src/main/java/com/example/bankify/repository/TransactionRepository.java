package com.example.bankify.repository;

import com.example.bankify.models.Account;
import com.example.bankify.models.Transaction;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findBySourceAccount(Account sourceAccount);

    List<Transaction> findByOriginAccount(Account originAccount);

    List<Transaction> findByStatus(Account status);

    List<Transaction> findByType(Account type);

    List<Transaction> findByDate(LocalDateTime transactionDate);

    @Query("SELECT t FROM Transaction t WHERE t.transactionDate BETWEEN :start AND :end")
    List<Transaction> findByTransactionDateBetween(LocalDateTime start, LocalDateTime end);
}
