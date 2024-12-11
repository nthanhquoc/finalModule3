package com.example.final_module3.Repo;

import com.example.final_module3.Model.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepo {
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement statement =BaseRepo.getConnection().prepareStatement("select * from books");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String idBook=resultSet.getString("id_book");
                String nameBook=resultSet.getString("name_book");
                String author=resultSet.getString("actor");
                String description=resultSet.getString("description_book");
                Integer number=resultSet.getInt("number_book");
                books.add(new Book(idBook,nameBook,author,description,number));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }
    public String findNameById(String bookId) {
        String bookName = null;
        try {
            PreparedStatement statement = BaseRepo.getConnection().prepareStatement("SELECT name_book FROM books WHERE id_book = ?");
            statement.setString(1, bookId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                bookName = resultSet.getString("name_book");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookName;
    }
}
