package com.jspider.jdbc_prepared_statement_crud_operation.controller;

import java.io.IOException;

import com.jspider.jdbc_prepared_statement_crud_operation.dao.BookDao;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class DeleteBookById extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		new BookDao().deleteBookByIdDao(id);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("book-management.jsp");
		dispatcher.forward(req, res);
	}
		
}
