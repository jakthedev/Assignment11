package com.codercampus.Assignment11.web;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;
import com.codercampus.Assignment11.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepo;

    @Autowired
    private TransactionService transactionService;

    @GetMapping("transactions")
    public String getRootWebpage(ModelMap model) {

        List<Transaction> allTransaction = transactionService.findAll();
        System.out.println(allTransaction);

        model.put("transactions", allTransaction);

        return "transactions";

    }

    @GetMapping("transactions/{transactionId}")
    public String getThisTransaction(@PathVariable("transactionId") Long id, ModelMap model) {
        //Transaction transaction = transactionService.findById(id);
//        List<Transaction> transRepoData2 = transactionService.findAll();
//        for (Transaction transaction : transRepoData2) {
//            if (transaction.getId() == id.intValue()) {
//                System.out.println(transaction);
//                model.put("transactions", transaction);
//            }
//        }

        Transaction theTranx = transactionService.findById(id);
        model.put("transaction", theTranx);


        return "transaction";
    }

//    @PostMapping("transaction")
//    public String postWebpageRoot(Transaction transaction) {
//        System.out.println(transaction);
//        return "transaction";
//    }

//    @PostMapping("transactions")
//    public String postRootWebpage(Transaction transaction) {
//        Transaction savedTransaction = TransactionService.save(transaction);
//        System.out.println(transaction);
//        return "redirect:/transaction";
//    }


//    @GetMapping("transactions")
//    public List<Transaction> getAllTransactions(Long id, String retailer, String description, LocalDateTime date,
//                                                BigDecimal amount, String type)
//    {
//        List<Transaction> transRepoData = transactionRepo.findAll();
//        System.out.println(transRepoData);
//            return transRepoData;
//        }
}


