package com.example.bankify.repository;

import com.example.bankify.enums.AccountType;
import com.example.bankify.models.Account;
import com.example.bankify.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Long, Account> {


    Optional<Account> findByAccountNumber(String accountNumber);

    @Query("SELECT a FROM Account a WHERE a.accountType = :accountType")
    Optional<Account> findByAccountType(@Param("accountType") AccountType accountType);

    List<Account> findByCustomer(Customer customer);

}
