package CodeTest;

public class ItemSearcher {

    /**
     * Searches for a library item by its title.
     *
     * @param library The library to search within.
     * @param title   The title of the item to search for.
     * @return The library item if found; null otherwise.
     */
    public static LibraryItem searchItemByTitle(Library library, String title) {
        for (LibraryItem item : library.getItems()) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Searches for a library item by its author.
     *
     * @param library The library to search within.
     * @param author  The author of the item to search for.
     * @return The library item if found; null otherwise.
     */
    public static LibraryItem searchItemByAuthor(Library library, String author) {
        for (LibraryItem item : library.getItems()) {
            if (item.getAuthor().equalsIgnoreCase(author)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Searches for a library item by its publication year.
     *
     * @param library         The library to search within.
     * @param publicationYear The publication year of the item to search for.
     * @return The library item if found; null otherwise.
     */
    public static LibraryItem searchItemByPublicationYear(Library library, int publicationYear) {
        for (LibraryItem item : library.getItems()) {
            if (item.getPublicationYear() == publicationYear) {
                return item;
            }
        }
        return null;
    }
}
