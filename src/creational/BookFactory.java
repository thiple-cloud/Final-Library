package creational;

import CodeTest.Book;
import CodeTest.LibraryItem;

/**
 * Factory class for creating Book objects.
 * Implements the CreateItem interface to ensure compliance with a generic factory structure.
 * This class encapsulates the creation logic for books, allowing the client to request
 * a LibraryItem without needing to know the specifics of the Book class implementation.
 */

public class BookFactory implements CreateItem{
    private String ISBN;
	private String title;
	private int publicationYear;
	private String author;
	private int ageRating;

    /**
     * Creates a new Book object with the specified attributes.
     * This method adheres to the CreateItem interface contract.
     *
     * @return A new instance of Book encapsulated as a LibraryItem.
     */

    public BookFactory (String title, String author, int publicationYear, int ageRating, String ISBN) {
		this.ISBN = ISBN;
        this.title = title;
        this.publicationYear = publicationYear;
        this.author = author;
        this.ageRating = ageRating;
	}
    
     /**
     * Creates a new Book object with the specified attributes.
     * This method adheres to the CreateItem interface contract.
     *
     * @return A new instance of Book encapsulated as a LibraryItem.
     */
    @Override
     public LibraryItem createItem() {
        Book newBook = new Book(title, author, publicationYear, ageRating, ISBN);
        return newBook;
    }
}
