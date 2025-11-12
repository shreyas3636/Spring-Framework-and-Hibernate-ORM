package com.example.demo.service;

import com.example.demo.dao.AccountDAO;
import com.example.demo.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {

    @Autowired
    private AccountDAO dao;

    @Transactional
    public void transfer(int fromId, int toId, double amount) {
        Account from = dao.findById(fromId);
        Account to = dao.findById(toId);

        if (from.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        dao.update(from);
        dao.update(to);
    }
}
