package com.jspider.jdbc_prepared_statement_crud_operation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jspider.jdbc_prepared_statement_crud_operation.connection.BookConnection;
import com.jspider.jdbc_prepared_statement_crud_operation.dto.Book;

public class BookDao
{
	@SuppressWarnings("rawtypes")
	PreparedStatement ps =null;
	Connection connection = BookConnection.getBookConnection();
	
	private final String INSERTBOOKQUERY = "insert into book(id, title, author, price)values(?,?,?,?)";
	private final String UPDATEBOOKDETAILSBYID = "update book set title=?,author=?,price=? where id=?";
	private final String DISPLAYPRODUCTBYID = "select * from book where id=?";
	private final String DISPLAYALLPRODUCT = "select * from book";
	private final String DELETEPRODUCTBYID = "delete from book where id=?";
	
	public Book insertBookDao(Book book)
	{
		try {
			ps = connection.prepareStatement(INSERTBOOKQUERY);
			ps.setInt(1, book.getId());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setDouble(4, book.getPrice());
			ps.execute();
			return book;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public int updateBookDetailsDao(Book book)
	{
		try {
				ps=connection.prepareStatement(UPDATEBOOKDETAILSBYID);
				ps.setString(1, book.getTitle());
				ps.setString(2, book.getAuthor());
				ps.setDouble(3, book.getPrice());
				ps.setInt(4, book.getId());
				return ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public Book getBookByIdDao(int id)
	{
		try {
			ps = connection.prepareStatement(DISPLAYPRODUCTBYID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			Book book  = null;
			if(rs.next())
			{
				int id1 = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				double price = rs.getDouble("price");
				
				book = new Book(id1, title, author, price);
			}
			return book;		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Book> displayAllBookDataDao()
	{
		try {
			ps=connection.prepareStatement(DISPLAYALLPRODUCT);
			ResultSet rs = ps.executeQuery();
			List<Book> books = new ArrayList<Book>();
			while(rs.next()) {
				int id1 = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				double price = rs.getDouble("price");
				
				
				Book book = new Book(id1, title, author, price);
				books.add(book);
				
			}
			return books;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public int deleteBookByIdDao(int id)
	{
		try {
			ps=connection.prepareStatement(DELETEPRODUCTBYID);
			ps.setInt(1, id);
			return ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
}
