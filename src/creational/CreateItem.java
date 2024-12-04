package creational;

import CodeTest.LibraryItem;

/**
 * An interface for creating items in a library system.
 * This interface defines a contract for classes that encapsulate
 * the creation of specific types of library items.
 */

public interface CreateItem {

    /**
     * Creates and returns a new LibraryItem.
     * The implementation of this method is responsible for creating
     * a specific type of LibraryItem, such as a Book, DVD, or other library entities.
     *
     * @return A new instance of a LibraryItem.
     */
        LibraryItem createItem();
    }
    

