package com.example.final_module3.Controller;

import com.example.final_module3.Model.Borrow;
import com.example.final_module3.Repo.BookRepo;
import com.example.final_module3.Service.IBookService;
import com.example.final_module3.Service.IBorrowService;
import com.example.final_module3.Service.implement.BookService;
import com.example.final_module3.Service.implement.BorrowService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "borrowController", urlPatterns = "/borrow")
public class BorrowController extends HttpServlet {
    private static IBorrowService borrowService = new BorrowService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookId = req.getParameter("bookId");
        IBookService bookRepo = new BookService();
        String bookName = bookRepo.findNameById(bookId);
        String borrowId = "MS-" + (int) (Math.random() * 1000);
        req.setAttribute("bookName", bookName);
        req.setAttribute("bookId", bookId);
        req.setAttribute("students", borrowService.getAllStudents());
        req.getRequestDispatcher("/WEB-INF/View/borrow.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String bookId = req.getParameter("bookId");
        String studentId = req.getParameter("studentId");
        LocalDateTime borrowDate = LocalDateTime.parse(req.getParameter("borrowDate"));
        LocalDateTime returnDate = LocalDateTime.parse(req.getParameter("returnDate"));

        Borrow borrow = new Borrow(id, bookId, studentId, borrowDate, returnDate);
        borrowService.addBorrow(borrow);

        resp.sendRedirect("/book");
    }
}
