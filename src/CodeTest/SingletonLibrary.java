package CodeTest;

import CodeTest.LibraryItem;
/*
import structural.AdapterPattern.CSVReader;
import structural.AdapterPattern.LegacyItem;
import structural.AdapterPattern.LegacyItemAdapter;
*/
import java.util.ArrayList;
import java.util.List;

/**
 * SingletonLibrary implements the Singleton pattern to ensure only one instance
 * exists.
 * It manages a collection of LibraryItem objects and integrates legacy items
 * from a CSV file.
 */
public class SingletonLibrary {

    private static SingletonLibrary instance;
    private List<LibraryItem> items;

    // Private constructor to prevent direct instantiation
    private SingletonLibrary() {
        items = new ArrayList<>();
//        loadLegacyItems(); // Load legacy items using the Adapter pattern
    }

    /**
     * Provides a global point of access to the SingletonLibrary instance.
     * 
     * @return SingletonLibrary instance
     */
    public static synchronized SingletonLibrary getInstance() {
        if (instance == null) {
            instance = new SingletonLibrary();
        }
        return instance;
    }

    /**
     * Adds a LibraryItem to the library's collection.
     * 
     * @param item LibraryItem to add
     */
    public void addItem(LibraryItem item) {
        items.add(item);
    }

    /**
     * Removes a LibraryItem from the library's collection.
     * 
     * @param item LibraryItem to remove
     */
    public void removeItem(LibraryItem item) {
        items.remove(item);
    }

    /**
     * Retrieves the list of all LibraryItems in the library.
     * 
     * @return List of LibraryItem
     */
    public List<LibraryItem> getItems() {
        return items;
    }
/*
    // Private method to load legacy items using the Adapter pattern
    private void loadLegacyItems() {
        CSVReader csvReader = new CSVReader();
        List<LegacyItem> legacyItems = csvReader.readCSV("legacy_items.csv");

        for (LegacyItem legacyItem : legacyItems) {
            // Use the Adapter to convert LegacyItem to LibraryItem
            LegacyItemAdapter adapter = new LegacyItemAdapter(legacyItem);
            items.add(adapter);
        }
    }
*/
}