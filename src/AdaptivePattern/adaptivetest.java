package AdaptivePattern;


import java.util.ArrayList;
import java.util.List;
import library.LibraryItem;


public class adaptivetest {
    public static void main(String[] args) {
        List<LibraryItem> libraryItems = new ArrayList<>();

        // Optionally add some predefined items to simulate existing data
        // libraryItems.add(new Book(...)); // Example predefined items

        // Step 2: Define the path to the legacy CSV collection
        String filePath = "library2-main/src/AdaptivePattern/LegacyCollection.csv";

        // Step 3: Use AdaptiveLibraryHelper to append legacy items
        libraryItems = AdaptiveDemoTool.appendLegacyItems(libraryItems, filePath);

        // Step 4: Display all items in the updated list
        System.out.println("All Library Items:");
        for (LibraryItem item : libraryItems) {
            System.out.println(item.getClass().getSimpleName() + ": " + item.getTitle() + " by " + item.getAuthor() +
                               " (" + item.getYear() + ")");
        }
    }
}