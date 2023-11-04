package com.henriquegc.picpaychallenge.controllers;

import com.henriquegc.picpaychallenge.domain.transaction.Transaction;
import com.henriquegc.picpaychallenge.dtos.TransactionDTO;
import com.henriquegc.picpaychallenge.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping()
    public Transaction createTransaction(@RequestBody TransactionDTO transaction) throws Exception {
        return this.transactionService.makeTransaction(transaction);
    }
}
