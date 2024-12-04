package CodeTest;

import java.time.LocalDate;

import observer.eventManager;

/**
 * Represents a book in the library.
 * Extends the LibraryItem class and implements the Borrowable interface.
 */
public class Book extends LibraryItem implements Borrowable {

    /** The ISBN number of the book. */
    private String ISBN;
    private eventManager events;

    /**
     * Constructs a new Book with the specified title, author, publication year, and
     * ISBN.
     *
     * @param title           The title of the book.
     * @param author          The author of the book.
     * @param publicationYear The year the book was published.
     * @param ISBN            The ISBN number of the book.
     */
    public Book(String title, String author, int publicationYear, int ageRating, String ISBN) {
        super(title, author, publicationYear, ageRating);
        this.ISBN = ISBN;
        events = new eventManager();
    }

    /**
     * Gets the ISBN number of the book.
     *
     * @return The ISBN number.
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Allows a user to borrow the book if they have permission and the book is
     * available.
     *
     * @param user The user attempting to borrow the book.
     * @throws Exception If the user cannot borrow items or the book is already
     *                   borrowed.
     */
    @Override
    public void borrowItem(LibraryItem libraryItem, User user) throws Exception {
        if (!user.canBorrow(user)) {
            throw new Exception(user.getName() + " does not have permission to borrow items.");
        }
        if (!isBorrowed) {
            isBorrowed = true;
            libraryItem.isBorrowed = true;
            dueDate = LocalDate.now().plusDays(14); // Books are due in 14 days
            System.out.println(getTitle() + " has been borrowed by " + user.getName() + ". Due on " + dueDate);
        } else {
            events.subscribe(libraryItem, user);
            throw new Exception(getTitle() + " is already borrowed.");
        }
    }

    /**
     * Allows a user to return the book if it was borrowed.
     *
     * @param user The user returning the book.
     * @throws Exception If the book was not borrowed.
     */
    @Override
    public void returnItem(LibraryItem libraryItem, User user) throws Exception {
        if (!isBorrowed) {
            throw new Exception(getTitle() + " was not borrowed.");
        }
        isBorrowed = false;
        libraryItem.isBorrowed = false;
        dueDate = null;
        System.out.println(getTitle() + " has been returned by " + user.getName() + ".");
        events.unsubscribe(libraryItem, user);
        events.update(libraryItem);
    }

    /**
     * Checks if the book is available for borrowing.
     *
     * @return True if the book is not borrowed; false otherwise.
     */
    @Override
    public boolean isAvailable() {
        return !isBorrowed;
    }

    /**
     * Gets the due date of the book if it is borrowed.
     *
     * @return The due date; null if the book is not borrowed.
     */
    @Override
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Provides the details of the book.
     *
     * @return A string containing the book's details.
     */
    @Override
    public String getDetails() {
        return "Book: " + getTitle() + " by " + getAuthor() +
                ", Published in: " + getPublicationYear() +
                ", ISBN: " + getISBN();
    }
}