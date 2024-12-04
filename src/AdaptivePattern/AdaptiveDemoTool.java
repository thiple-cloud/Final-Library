package AdaptivePattern;

import java.util.ArrayList;
import java.util.List;

import CodeTest.LibraryItem;



public class AdaptiveDemoTool {
    /**
     * Reads a CSV file, adapts the legacy data into LibraryItem objects, and appends it to an existing list.
     * 
     * @param existingItems The existing list of LibraryItem objects to which the adapted items will be added.
     * @param filePath      The file path to the legacy CSV collection.
     * @return The combined list of LibraryItem objects (existing + adapted).
     */
    public static List<CodeTest.LibraryItem> appendLegacyItems(List<LibraryItem> existingItems, String filePath) {
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
                 // Return the combined list
        return existingItems;
    }
}
