package com.example.bankify.repository;

import com.example.bankify.enums.CardType;
import com.example.bankify.models.Account;
import com.example.bankify.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findByAccount(Account account);

    Optional<Card> findByCardNumber(Spring cardNumber);

    List<Card> findByAccountAndStatus(Account account, boolean status);

    List<Card> findByType(CardType type);
}
