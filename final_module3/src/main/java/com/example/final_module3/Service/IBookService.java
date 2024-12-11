package com.example.final_module3.Service;

import com.example.final_module3.Model.Book;

import java.util.List;

public interface IBookService {
    public List<Book> getBooks();
    public String findNameById(String bookId);
}
