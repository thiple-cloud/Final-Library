package observer;

import CodeTest.LibraryItem;

/**
 * Interface for event notification in a library system.
 * Provides a method to notify users about updates related to a library item, 
 * such as its availability for reservation.
 */
public interface eventNotification {
      /**
     * Notifies users on the waitlist for a specific library item that it is now available.
     *
     * @param item The library item that is available to reserve.
     */
    public void update (LibraryItem c); //method to update users on a waitlist for an item that the item is available to reserve
}


