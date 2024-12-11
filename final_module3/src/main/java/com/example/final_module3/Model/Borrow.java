package com.example.final_module3.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Borrow {
    private String id;
    private String idBook;
    private String idStudent;
    private boolean status=false;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;

    public Borrow(String id, String idBook, String idStudent, LocalDateTime borrowDate, LocalDateTime returnDate) {
        this.id = id;
        this.idBook=idBook;
        this.idStudent=idStudent;
        this.status=false;
        this.borrowDate=borrowDate;
        this.returnDate=returnDate;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getIdBook() {
        return idBook;
    }
    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }
    public String getIdStudent() {
        return idStudent;
    }
    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }
    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }
    public LocalDateTime getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

}
