package AdaptivePattern;

import java.util.*;
import library.LibraryItem;
import library.Book;
import library.Magazine;

public class LegacyLibraryAdapter {

    /**
     * Adapts a legacy collection of strings to a list of LibraryItem objects.
     * Each string in the legacy collection represents an item in the format:
     * "Type,Title,Author,Year,Publication Date"
     *
     * @param legacyData A collection of strings representing legacy library data.
     * @return A list of LibraryItem objects.
     */
    public List<LibraryItem> adaptLegacyData(Collection<String> legacyData) {
        Map<String, LibraryItem> libraryItemsMap = new HashMap<>();
        Map<String, String> unknownItemsMap = new HashMap<>(); // To store unknown items as strings
        int bookCount = 1;
        int magazineCount = 1;
        int unknownCount = 1;

        for (String data : legacyData) {
            try {
                // Split the legacy data string by commas
                String[] values = data.split(",");

                // Ensure the data has at least 4 columns (Type, Title, Author, Year)
                if (values.length < 4) {
                    System.out.println("Skipping invalid data: " + data);
                    continue;
                }

                // Parse the data
                String typeStr = values[0].trim();
                String title = values[1].trim();
                String author = values[2].trim();
                String yearStr = values[3].trim(); // Changed to String to handle year-month formats

                // Additional fields for Book and Magazine
                String isbn = UUID.randomUUID().toString(); // Generate a unique ISBN
                boolean isPhysical = true; // Default to physical for simplicity
                int ageRating = 0; // Default age rating
                String genre = "Unknown"; // Default genre

                // Validate and handle the year parsing
                int year = -1; // Default to -1 if year is not valid
                try {
                    if (yearStr.contains("-")) {
                        // If the year is in the "YYYY-MM" format, just extract the year part
                        year = Integer.parseInt(yearStr.split("-")[0]);
                    } else {
                        // Otherwise, parse it as a regular year
                        year = Integer.parseInt(yearStr);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid year format for data: " + data);
                    continue; // Skip this record if year parsing fails
                }

                LibraryItem item;

                if (typeStr.equalsIgnoreCase("BOOK")) {
                    // Creating a Book item with provided details
                    item = new Book(isbn, title, year, author, genre, isPhysical, ageRating);
                    libraryItemsMap.put("LegBook" + bookCount++, item);
                } else if (typeStr.equalsIgnoreCase("MAGAZINE")) {
                    // Creating a Magazine item with default values for missing fields
                    item = new Magazine(isbn, title, year, author, isPhysical, ageRating, "General", "Unknown Publisher", 1);
                    libraryItemsMap.put("LegMag" + magazineCount++, item);  // Corrected to LegMag
                } else {
                    String unknownData = "Unknown type: " + typeStr + ", Data: " + data;
                    unknownItemsMap.put("LegUnknown" + unknownCount++, unknownData); // Store unknown data in
                    System.out.println(unknownData);
                    continue; // Skip unknown types
                }

            } catch (Exception e) {
                System.out.println("Error processing data: " + data);
                e.printStackTrace();
            }
        }

        // Convert the Map to a List of LibraryItems (if returning a list)
        return new ArrayList<>(libraryItemsMap.values());
    }
}
