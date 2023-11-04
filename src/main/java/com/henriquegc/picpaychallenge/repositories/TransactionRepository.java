package com.henriquegc.picpaychallenge.repositories;

import com.henriquegc.picpaychallenge.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
