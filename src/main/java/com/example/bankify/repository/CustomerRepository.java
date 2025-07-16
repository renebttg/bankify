package com.example.bankify.repository;

import com.example.bankify.models.Account;
import com.example.bankify.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByCpf(String cpf);

    Optional<Customer> findByAccounts(Account account);

    @Query("SELECT c FROM Customer c JOIN c.accounts a WHERE a.id = :accountId")
    Optional<Customer> findByAccountId(@Param("accountId") Long accountId);




}
