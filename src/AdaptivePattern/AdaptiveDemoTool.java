package AdaptivePattern;

import java.util.ArrayList;
import java.util.List;

import CodeTest.LibraryItem;

/**
 * A utility class for adapting legacy CSV data into LibraryItem objects and appending them to an existing collection.
 * This class provides methods for processing legacy data and integrating it into an existing list of LibraryItems.
 */
public class AdaptiveDemoTool {

    /**
     * Reads a CSV file, adapts the legacy data into LibraryItem objects, and appends it to an existing list.
     *
     * This method reads legacy data from a CSV file, converts it into LibraryItem objects using the LegacyLibraryAdapter, 
     * and then appends the new items to the provided list of existing LibraryItems. 
     * The first row of the CSV is considered a header and is skipped.
     *
     * @param existingItems The existing list of LibraryItem objects to which the adapted items will be added.
     * @param filePath      The file path to the legacy CSV collection.
     * @return The combined list of LibraryItem objects (existing + adapted).
     *         The returned list includes both the original items and the newly adapted items.
     */
    public static List<LibraryItem> appendLegacyItems(List<LibraryItem> existingItems, String filePath) {
        // Read the CSV file
        List<String[]> csvData = csvReader.readCSV(filePath);

        // Convert CSV data into a list of legacy data (in String format)
        List<String> legacyData = new ArrayList<>();
        boolean isFirstRow = true;
        for (String[] row : csvData) {
            if (isFirstRow) {
                isFirstRow = false; // Skip the header row
                continue;
            }
            legacyData.add(String.join(",", row));
        }

        // Adapt the CSV data to LibraryItem objects
        LegacyLibraryAdapter adapter = new LegacyLibraryAdapter();
        // Append the adapted items to the existing list
        List<LibraryItem> legacyItems = adapter.adaptLegacyData(legacyData);

        // Append the adapted items to the existing list
        existingItems.addAll(legacyItems);

        // Return the combined list of existing and adapted items
        return existingItems;
    }
}
