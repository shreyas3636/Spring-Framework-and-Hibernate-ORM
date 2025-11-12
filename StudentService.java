package com.example.demo.service;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDAO dao;

    @Transactional
    public void addStudent(Student s) { dao.save(s); }

    @Transactional(readOnly = true)
    public List<Student> listStudents() { return dao.findAll(); }

    @Transactional
    public void updateStudent(Student s) { dao.update(s); }

    @Transactional
    public void deleteStudent(int id) { dao.delete(id); }
}
