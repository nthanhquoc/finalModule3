package com.example.final_module3.Service.implement;

import com.example.final_module3.Model.Borrow;
import com.example.final_module3.Model.Student;
import com.example.final_module3.Service.IBorrowService;

import java.util.ArrayList;
import java.util.List;

public class BorrowService implements IBorrowService {
    private static List<Student> students = new ArrayList<>();

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public void addBorrow(Borrow borrow) {
    }
}
