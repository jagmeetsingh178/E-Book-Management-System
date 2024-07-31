package com.jspider.jdbc_prepared_statement_crud_operation.dto;

import java.util.Objects;

public class Book 
{
	private int id;
	private String title;
	private String author;
	private double price;
	
	
	//Constructor
		public Book(int id, String title, String author, double price) {
			super();
			this.id = id;
			this.title = title;
			this.author = author;
			this.price = price;
		}


		
		//Getter Setter Method
		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getAuthor() {
			return author;
		}


		
		//Hash Code Method
		@Override
		public int hashCode() {
			return Objects.hash(author, id, price, title);
		}



		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Book other = (Book) obj;
			return Objects.equals(author, other.author) && id == other.id
					&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
					&& Objects.equals(title, other.title);
		}



		public void setAuthor(String author) {
			this.author = author;
		}


		public double getPrice() {
			return price;
		}


		public void setPrice(double price) {
			this.price = price;
		}



		
		//toString Method
		@Override
		public String toString() {
			return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + "]";
		}
		
		
		
		
		
		
	
	
	
}
