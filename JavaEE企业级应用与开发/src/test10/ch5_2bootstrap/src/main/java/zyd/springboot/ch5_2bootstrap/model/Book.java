package zyd.springboot.ch5_2bootstrap.model;
public class Book {
	String isbn;
	Double price;
	String bname;
	String publishing;
	String author;
	String picture;
	public Book(String isbn, Double price, String bname, String publishing, String author, String picture) {
		super();
		this.isbn = isbn;
		this.price = price;
		this.bname = bname;
		this.publishing = publishing;
		this.author = author;
		this.picture = picture;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getPublishing() {
		return publishing;
	}
	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
}
