package com.example.demo;

import com.example.demo.config.AppConfig;
import com.example.demo.entity.Account;
import com.example.demo.entity.Student;
import com.example.demo.service.BankService;
import com.example.demo.service.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        StudentService studentService = context.getBean(StudentService.class);
        BankService bankService = context.getBean(BankService.class);

        // --- Dependency Injection + Hibernate CRUD ---
        studentService.addStudent(new Student("Alice", "alice@example.com"));
        studentService.addStudent(new Student("Bob", "bob@example.com"));

        System.out.println("Students in DB:");
        studentService.listStudents().forEach(s ->
                System.out.println(s.getId() + " - " + s.getName() + " - " + s.getEmail())
        );

        // --- Transaction Management Example ---
        Account acc1 = new Account(1, "Alice", 1000.0);
        Account acc2 = new Account(2, "Bob", 500.0);

        var accountDAO = context.getBean(com.example.demo.dao.AccountDAO.class);
        accountDAO.save(acc1);
        accountDAO.save(acc2);

        System.out.println("\nTransferring 200 from Alice to Bob...");
        bankService.transfer(1, 2, 200.0);

        System.out.println("Transfer successful!");

        context.close();
    }
}
