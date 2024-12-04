package CodeTest;

import java.time.LocalDate;

public interface Borrowable {

	    /**
	     * Allows a user to borrow the item.
	     *
	     * @param user The user attempting to borrow the item.
	     * @throws Exception If the item cannot be borrowed.
	     */
	    void borrowItem(User user) throws Exception;

	    /**
	     * Allows a user to return the borrowed item.
	     *
	     * @param user The user returning the item.
	     * @throws Exception If the item cannot be returned.
	     */
	    void returnItem(User user) throws Exception;

	    /**
	     * Checks if the item is available for borrowing.
	     *
	     * @return True if the item is available; false otherwise.
	     */
	    boolean isAvailable();

	    /**
	     * Gets the due date of the borrowed item.
	     *
	     * @return The due date; null if the item is not borrowed.
	     */
	    LocalDate getDueDate();
	}

