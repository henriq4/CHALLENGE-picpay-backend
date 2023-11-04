package com.henriquegc.picpaychallenge.services;

import com.henriquegc.picpaychallenge.domain.transaction.Transaction;
import com.henriquegc.picpaychallenge.domain.user.User;
import com.henriquegc.picpaychallenge.dtos.TransactionDTO;
import com.henriquegc.picpaychallenge.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    public Transaction makeTransaction(TransactionDTO transaction) throws Exception {
        User payer = userService.getUserById(transaction.payerId());
        User payee = userService.getUserById(transaction.payeeId());

        userService.validateTransaction(payer, transaction.amount());

        if (!this.isTransactionAuthorized()) {
            throw new Exception("transacao nao autorizada");
        }

        Transaction newTransaction = new Transaction(transaction.amount(), payer, payee);

        payer.setAmount(payer.getAmount().subtract(transaction.amount()));
        payee.setAmount(payee.getAmount().add(transaction.amount()));

        transactionRepository.save(newTransaction);
        userService.putUser(payer);
        userService.putUser(payee);

        return newTransaction;
    }

    public boolean isTransactionAuthorized() {
        String url = "https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc";

        ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity(url, Map.class);

        if (!(authorizationResponse.getStatusCode() == HttpStatus.OK)) {
            return false;
        }

        if (!("Autorizado".equalsIgnoreCase((String) authorizationResponse.getBody().get("message")))) {
            return false;
        }

        return true;
    }

}
