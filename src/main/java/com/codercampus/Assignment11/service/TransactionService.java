package com.codercampus.Assignment11.service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction findById(Long id) {

        Optional<Transaction> tranxOpt = transactionRepository.findAll()
                .stream()
                .filter(tranx -> tranx.getId().equals(id))
                .findAny();


            return tranxOpt.orElse(new Transaction());
         //return transactionRepository.findById(id);
        }

        public List<Transaction> findAll() {
        List<Transaction> tranx = transactionRepository.findAll();
        Collections.sort(tranx, Comparator.comparing(Transaction::getDate));
        return tranx;
        }
    }

