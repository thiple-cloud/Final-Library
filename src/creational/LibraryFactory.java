package creational;
import CodeTest.Book;
import CodeTest.Magazine;

public class LibraryFactory {
    public Book createBook(String title, String author, int publicationYear, int ageRating, String ISBN){
        BookFactory bookFactory = new BookFactory(title, author, publicationYear, ageRating, ISBN);
		Book newBook = (Book) bookFactory.createItem();
		return newBook;
    }

    public Magazine createMagazine(String title, String author, int publicationYear, int ageRating, int issueNumber){
        MagazineFactory magazineFactory = new MagazineFactory(title, author, publicationYear, ageRating, issueNumber);
		Magazine newMagazine = (Magazine) magazineFactory.createItem();
		return newMagazine;

    
}
}

