package CodeTest;

public class ItemReserver { 

    /**
     * Attempts to reserve (borrow) an item for a user.
     *
     * @param item The library item to reserve.
     * @param user The user attempting to reserve the item.
     */
    public static void reserveItem(LibraryItem item, User user) {
        if (item instanceof Borrowable) {
            Borrowable borrowableItem = (Borrowable) item;
            try {
                borrowableItem.borrowItem(user);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println(item.getTitle() + " is not borrowable.");
        }
    }

    /**
     * Attempts to return a borrowed item for a user.
     *
     * @param item The library item to return.
     * @param user The user returning the item.
     */
    public static void returnItem(LibraryItem item, User user) {
        if (item instanceof Borrowable) {
            Borrowable borrowableItem = (Borrowable) item;
            try {
                borrowableItem.returnItem(user);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println(item.getTitle() + " is not borrowable.");
        }
    }
}