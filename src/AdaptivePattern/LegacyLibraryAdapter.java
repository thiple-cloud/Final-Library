package AdaptivePattern;

import java.util.*;
import CodeTest.*;


public class LegacyLibraryAdapter {
    /**
     * Adapts a legacy collection of strings to a list of LibraryItem objects.
     * Each string in the legacy collection represents an item in the format:
     * "Type,Title,Author,Year,Publication Date", where:
     * - Type is either "Book" or "Magazine"
     * - Title is the title of the item
     * - Author is the author or creator of the item
     * - Year is the publication year (or "YYYY-MM" format)
     * - Publication Date (for magazines) may include the issue number in some cases.
     * 
     * <p>This method parses the provided data and creates corresponding LibraryItem objects.
     * For Books, an ISBN is generated, and for Magazines, the issue number is extracted 
     * from the publication date (if available). Invalid or incomplete data are logged and 
     * skipped.</p>
     *
     * @param legacyData A collection of strings, each representing legacy library data in the format mentioned above.
     * @return A list of LibraryItem objects created from the legacy data.
     */
    public List<LibraryItem> adaptLegacyData(Collection<String> legacyData) {
        Map<String, LibraryItem> libraryItemsMap = new HashMap<>();
        int bookCount = 1, magazineCount = 1;
    
        for (String data : legacyData) {
            try {
                String[] values = data.split(",");
                if (values.length < 4) {
                    System.out.println("Skipping invalid data (not enough fields): " + data);
                    continue;
                }
    
                String typeStr = values[0].trim();
                String title = values[1].trim();
                String author = values[2].trim();
                String yearStr = values[3].trim();
    
                // Validate year
                int year = -1;
                try {
                    if (yearStr.contains("-")) {
                        year = Integer.parseInt(yearStr.split("-")[0]); // Extract the year from "YYYY-MM"
                    } else {
                        year = Integer.parseInt(yearStr);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid year format for data: " + data);
                    continue;
                }
    
                LibraryItem item = null;
    
                if (typeStr.equalsIgnoreCase("Book")) {
                    // Books don't require the fifth column
                    String isbn = UUID.randomUUID().toString();
                    item = new Book(title, author, year, 0, isbn); // Default ageRating = 0
                    libraryItemsMap.put("LegBook" + bookCount++, item);
    
                } else if (typeStr.equalsIgnoreCase("Magazine")) {
                    // Magazines require a fifth column for the issue number
                    if (values.length < 5) {
                        System.out.println("Skipping invalid magazine data (missing issue): " + data);
                        continue;
                    }
    
                    String issueStr = values[4].trim();
                    int issueNumber = 1; // Default issue number
                    try {
                        String[] parts = issueStr.split("\\D+"); // Extract first number
                        for (String part : parts) {
                            if (!part.isEmpty()) {
                                issueNumber = Integer.parseInt(part);
                                break;
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid issue number format for data: " + data);
                    }
    
                    item = new Magazine(title, author, year, 0, issueNumber);
                    libraryItemsMap.put("LegMag" + magazineCount++, item);
    
                } else {
                    // Skip unknown types
                    System.out.println("Unknown type: " + data);
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Error processing data: " + data + ". Exception: " + e.getMessage());
            }
        }
    
        return new ArrayList<>(libraryItemsMap.values());
    }
}
