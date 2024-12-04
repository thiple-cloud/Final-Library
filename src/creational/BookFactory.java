package creational;

import CodeTest.Book;
import CodeTest.LibraryItem;

public class BookFactory implements CreateItem{
    private String ISBN;
	private String title;
	private int publicationYear;
	private String author;
	private int ageRating;

    public BookFactory (String title, String author, int publicationYear, int ageRating, String ISBN) {
		this.ISBN = ISBN;
        this.title = title;
        this.publicationYear = publicationYear;
        this.author = author;
        this.ageRating = ageRating;
	}
    
    @Override
     public LibraryItem createItem() {
        Book newBook = new Book(title, author, publicationYear, ageRating, ISBN);
        return newBook;
    }
}
