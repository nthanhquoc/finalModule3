package com.example.final_module3.Service.implement;

import com.example.final_module3.Model.Borrow;
import com.example.final_module3.Model.Student;
import com.example.final_module3.Service.IBorrowService;

import java.util.ArrayList;
import java.util.List;

public class BorrowService implements IBorrowService {
    private static List<Student> students = new ArrayList<>();

    static {
        // Dummy data
        students.add(new Student(1, "Alice Johnson", "Class A"));
        students.add(new Student(2, "Bob Smith", "Class B"));
        students.add(new Student(3, "Charlie Brown", "Class A"));
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public void addBorrow(Borrow borrow) {
        // Logic to save borrow details to the database
    }
}
