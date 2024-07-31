package com.jspider.jdbc_prepared_statement_crud_operation.controller;

import java.io.IOException;

import com.jspider.jdbc_prepared_statement_crud_operation.dao.BookDao;
import com.jspider.jdbc_prepared_statement_crud_operation.dto.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(value="/bookupdate")
public class UpdateBookDetailsById extends HttpServlet 
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		BookDao dao = new BookDao();
		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		double price = Double.parseDouble(req.getParameter("price"));
		
		Book  book = new Book(id, title, author, price);
		dao.updateBookDetailsDao(book);
		req.getRequestDispatcher("book-management.jsp").forward(req, res);
	}
}
