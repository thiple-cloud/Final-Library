package creational;
import CodeTest.Book;
import CodeTest.Magazine;

/**
 * A factory class to create various library items such as books and magazines.
 * This class uses specific item factories to encapsulate the creation logic.
 */

public class LibraryFactory {
    
    /**
     * Creates a new Book instance using the BookFactory.
     *
     * @param title           The title of the book.
     * @param author          The author of the book.
     * @param publicationYear The year the book was published.
     * @param ageRating       The age rating of the book.
     * @param ISBN            The International Standard Book Number (ISBN) of the book.
     * @return A new Book instance.
     */

    public Book createBook(String title, String author, int publicationYear, int ageRating, String ISBN){
        BookFactory bookFactory = new BookFactory(title, author, publicationYear, ageRating, ISBN);
		Book newBook = (Book) bookFactory.createItem();
		return newBook;
    }

    /**
     * Creates a new Magazine instance using the MagazineFactory.
     *
     * @param title           The title of the magazine.
     * @param author          The author of the magazine.
     * @param publicationYear The year the magazine was published.
     * @param ageRating       The age rating of the magazine.
     * @param issueNumber     The issue number of the magazine.
     * @return A new Magazine instance.
     */
    public Magazine createMagazine(String title, String author, int publicationYear, int ageRating, int issueNumber){
        MagazineFactory magazineFactory = new MagazineFactory(title, author, publicationYear, ageRating, issueNumber);
		Magazine newMagazine = (Magazine) magazineFactory.createItem();
		return newMagazine;

    
}
}

