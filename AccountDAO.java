package com.example.demo.dao;

import com.example.demo.entity.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Account findById(int id) {
        return sessionFactory.getCurrentSession().get(Account.class, id);
    }

    public void update(Account account) {
        sessionFactory.getCurrentSession().merge(account);
    }

    public void save(Account account) {
        sessionFactory.getCurrentSession().persist(account);
    }
}
