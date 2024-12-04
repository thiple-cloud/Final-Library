package CodeTest;

import java.time.LocalDate;

/**
 * Represents a magazine in the library.
 * Extends the LibraryItem class and implements the Borrowable interface.
 */
public class Magazine extends LibraryItem implements Borrowable {

    /** The issue number of the magazine. */
    private int issueNumber;

    /**
     * Constructs a new Magazine with the specified title, author, publication year,
     * and issue number.
     *
     * @param title           The title of the magazine.
     * @param author          The author of the magazine.
     * @param publicationYear The year the magazine was published.
     * @param issueNumber     The issue number of the magazine.
     */
    public Magazine(String title, String author, int publicationYear, int ageRating, int issueNumber) {
        super(title, author, publicationYear, ageRating);
        this.issueNumber = issueNumber;
    }

    /**
     * Gets the issue number of the magazine.
     *
     * @return The issue number.
     */
    public int getIssueNumber() {
        return issueNumber;
    }

    /**
     * Allows a user to borrow the magazine if they have permission and it is
     * available.
     *
     * @param user The user attempting to borrow the magazine.
     * @throws Exception If the user cannot borrow items or the magazine is already
     *                   borrowed.
     */
    @Override
    public void borrowItem(User user) throws Exception {
        if (!user.canBorrow()) {
            throw new Exception(user.getName() + " does not have permission to borrow items.");
        }
        if (!isBorrowed) {
            isBorrowed = true;
            dueDate = LocalDate.now().plusDays(7); // Magazines are due in 7 days
            System.out.println(getTitle() + " (Magazine) has been borrowed by " + user.getName() +
                    ". Due on " + dueDate);
        } else {
            throw new Exception(getTitle() + " is already borrowed.");
        }
    }

    /**
     * Allows a user to return the magazine if it was borrowed.
     *
     * @param user The user returning the magazine.
     * @throws Exception If the magazine was not borrowed.
     */
    @Override
    public void returnItem(User user) throws Exception {
        if (!isBorrowed) {
            throw new Exception(getTitle() + " was not borrowed.");
        }
        isBorrowed = false;
        dueDate = null;
        System.out.println(getTitle() + " (Magazine) has been returned by " + user.getName() + ".");
    }

    /**
     * Checks if the magazine is available for borrowing.
     *
     * @return True if the magazine is not borrowed; false otherwise.
     */
    @Override
    public boolean isAvailable() {
        return !isBorrowed;
    }

    /**
     * Gets the due date of the magazine if it is borrowed.
     *
     * @return The due date; null if the magazine is not borrowed.
     */
    @Override
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Provides the details of the magazine.
     *
     * @return A string containing the magazine's details.
     */
    @Override
    public String getDetails() {
        return "Magazine: " + getTitle() + " by " + getAuthor() +
                ", Published in: " + getPublicationYear() +
                ", Issue Number: " + getIssueNumber();
    }
}