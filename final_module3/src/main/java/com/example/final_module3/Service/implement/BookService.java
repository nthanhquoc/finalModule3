package com.example.final_module3.Service.implement;

import com.example.final_module3.Model.Book;
import com.example.final_module3.Repo.BookRepo;
import com.example.final_module3.Service.IBookService;

import java.util.List;

public class BookService implements IBookService {
    private static final BookRepo bookRepo = new BookRepo();
    public List<Book> getBooks() {
        return bookRepo.findAll();
    }
    public String findNameById(String bookId){
        return bookRepo.findNameById(bookId);
    }
}
