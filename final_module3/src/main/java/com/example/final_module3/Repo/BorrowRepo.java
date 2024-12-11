package com.example.final_module3.Repo;

import com.example.final_module3.Model.Borrow;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowRepo {
    public List<Borrow> findAll() {
        List<Borrow> borrows = new ArrayList<>();
        try {
            PreparedStatement statement = BaseRepo.getConnection().prepareStatement("SELECT * FROM borrow_cards");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id_card");
                String idBook = resultSet.getString("id_book");
                int idStudent = resultSet.getInt("id_student");
                boolean status = resultSet.getBoolean("status_borrow");
                Timestamp borrowDate = resultSet.getTimestamp("date_borrow");
                Timestamp returnDate = resultSet.getTimestamp("date_payment");

                Borrow borrow = new Borrow(
                        id,
                        idBook,
                        String.valueOf(idStudent), // Chuyển ID sinh viên thành String
                        borrowDate.toLocalDateTime(),
                        returnDate != null ? returnDate.toLocalDateTime() : null
                );
                borrow.setStatus(status);
                borrows.add(borrow);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return borrows;
    }
    public void save(Borrow borrow) {
        try {
            PreparedStatement statement = BaseRepo.getConnection().prepareStatement(
                    "INSERT INTO borrow_cards (id_card, id_book, id_student, status_borrow, date_borrow, date_payment) VALUES (?, ?, ?, ?, ?, ?)"
            );
            statement.setString(1, borrow.getId());
            statement.setString(2, borrow.getIdBook());
            statement.setInt(3, Integer.parseInt(borrow.getIdStudent()));
            statement.setBoolean(4, borrow.isStatus());
            statement.setTimestamp(5, Timestamp.valueOf(borrow.getBorrowDate()));
            statement.setTimestamp(6, borrow.getReturnDate() != null ? Timestamp.valueOf(borrow.getReturnDate()) : null);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
