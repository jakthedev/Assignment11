package com.codercampus.Assignment11.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.stereotype.Repository;

import com.codercampus.Assignment11.domain.Transaction;

@Repository
public class TransactionRepository {
	private List<Transaction> transactions = new ArrayList<>(100);
	

	public TransactionRepository () {
		super();
		populateData();
	}
	
	public List<Transaction> findAll() {
		//System.out.println(transactions);
		return transactions;
	}

	@SuppressWarnings("unchecked")
	@Test
	public void populateData() {
		try (FileInputStream fileInputStream = new FileInputStream("transactions.txt");
			 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);)
		{
			this.transactions = (List<Transaction>) objectInputStream.readObject();
			//System.out.println(transactions);

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public Transaction findById(Long id) {
		Transaction idNum = transactions.get(Math.toIntExact(id));

		return idNum;
	}
}
