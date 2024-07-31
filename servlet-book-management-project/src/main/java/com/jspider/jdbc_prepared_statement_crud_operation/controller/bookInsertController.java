package com.jspider.jdbc_prepared_statement_crud_operation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.jspider.jdbc_prepared_statement_crud_operation.dao.BookDao;
import com.jspider.jdbc_prepared_statement_crud_operation.dto.Book;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class bookInsertController implements Servlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookDao dao = new BookDao();
		
		PrintWriter printWriter = res.getWriter();
		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		double price = Double.parseDouble(req.getParameter("price"));
		
		Book book = new Book(id, title, author, price);
		dao.insertBookDao(book);
		
		printWriter.write("<html><body>");
		
		printWriter.write("<h3> Book-------------Details</h3>");
		printWriter.write("<h3>id= "+id+"</h3><h3> title= "+title+"</h3><h3> author = "+author+"</h3><h3> price = "+price+"</h3>");
		
		printWriter.write("<html><body>");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("book-insert.jsp");
		dispatcher.include(req, res);
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
