package CodeTest;

import java.util.ArrayList;
import java.util.List;

/**
 * SingletonLibraryDoubleCheckedLocking implements the Singleton pattern to ensure only one instance
 * exists.
 * It manages a collection of LibraryItem objects.
 */
public class SingletonLibraryDC {

    private static SingletonLibraryDC instance;
    private List<LibraryItem> items;

    // Private constructor to prevent direct instantiation
    private SingletonLibraryDC() {
        items = new ArrayList<>();
    }

    /**
     * Provides a global point of access to the SingletonLibraryDoubleCheckedLocking instance.
     * 
     * using the Double-Checked Locking technique to reduce the overhead of synchronization.
     * @return SingletonLibraryDoubleCheckedLocking instance
     */
    public static SingletonLibraryDC getInstance() {
        if (instance == null) { // First check (no locking)
            synchronized (SingletonLibraryDC.class) {
                if (instance == null) { // Second check (with locking)
                    instance = new SingletonLibraryDC();
                }
            }
        }
        return instance;
    }

//     /**
//      * Adds a LibraryItem to the library's collection.
//      * 
//      * @param item LibraryItem to add
//      */
//     public void addItem(LibraryItem item) {
//         items.add(item);
//     }

//     /**
//      * Removes a LibraryItem from the library's collection.
//      * 
//      * @param item LibraryItem to remove
//      */
//     public void removeItem(LibraryItem item) {
//         items.remove(item);
//     }

//     /**
//      * Retrieves the list of all LibraryItems in the library.
//      * 
//      * @return List of LibraryItem
//      */
//     public List<LibraryItem> getItems() {
//         return items;
//     }
}