package com.example.final_module3.Service;

import com.example.final_module3.Model.Borrow;
import com.example.final_module3.Model.Student;

import java.util.List;

public interface IBorrowService {
    List<Student> getAllStudents();
    void addBorrow(Borrow borrow);
}
