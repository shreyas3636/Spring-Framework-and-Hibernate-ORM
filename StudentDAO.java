package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(student);
    }

    public Student findById(int id) {
        return sessionFactory.getCurrentSession().get(Student.class, id);
    }

    public List<Student> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Student", Student.class).list();
    }

    public void update(Student student) {
        sessionFactory.getCurrentSession().merge(student);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student s = session.get(Student.class, id);
        if (s != null) session.remove(s);
    }
}
