package CodeTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a library that contains a collection of library items.
 */
public class Library {

    /** The list of items in the library. */
    private List<LibraryItem> items;

    /**
     * Constructs a new Library with an empty list of items.
     */
    public Library() {
        items = new ArrayList<LibraryItem>();
    }

    /**
     * Adds an item to the library's collection.
     *
     * @param item The library item to add.
     */
    public void addItem(LibraryItem item) {
        items.add(item);
        System.out.println(item.getTitle() + " has been added to the library.");
    }

    /**
     * Removes an item from the library's collection.
     *
     * @param item The library item to remove.
     */
    public void removeItem(LibraryItem item) {
        items.remove(item);
        System.out.println(item.getTitle() + " has been removed from the library.");
    }

    /**
     * Lists all items currently in the library.
     */
    public void listAllItems() {
        System.out.println("Library items:");
        for (LibraryItem item : items) {
            System.out.println(item.getDetails());
        }
    }

    /**
     * Lists all borrowable items and their availability status.
     */
    public void listBorrowableItems() {
        System.out.println("Borrowable items:");
        for (LibraryItem item : items) {
            if (item instanceof Borrowable) {
                Borrowable borrowableItem = (Borrowable) item;
                System.out.println(item.getDetails() + (borrowableItem.isAvailable()
                        ? " - Available"
                        : " - Borrowed, Due on " + borrowableItem.getDueDate()));
            }
        }
    }

    /**
     * Gets the list of library items.
     *
     * @return The list of library items.
     */
    public List<LibraryItem> getItems() {
        return items;
    }
}