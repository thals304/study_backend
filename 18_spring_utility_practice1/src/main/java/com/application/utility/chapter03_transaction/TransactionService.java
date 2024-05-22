package com.application.utility.chapter03_transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

	@Autowired
	private TransactionDAO transactionDAO;
	
	@Transactional
	public void bankTransfer() {
		transactionDAO.transfer();
		System.out.println(0/0);
		transactionDAO.deposit();
	}
	
	@Transactional
	public void addOrder() {
		
		transactionDAO.increasePoints();
		transactionDAO.decreaseCartQty();
		transactionDAO.increaseOrerQty();
	}
}
