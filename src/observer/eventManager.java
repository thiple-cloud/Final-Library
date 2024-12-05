package observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CodeTest.*;
/**
 * EventManager handles subscriptions and notifications for library items.
 * Users can subscribe to specific library items to receive notifications when the item becomes available.
 */
public class eventManager {
    // Static map to track subscribers for each LibraryItem.
    public static Map<LibraryItem, List<User>> subscribers = new HashMap<>();
   public static List <User> queue = new ArrayList<>();
   public static User queueUser;

   /**
     * Subscribes a user to a specific library item.
     *
     * @param item The library item the user wants to subscribe to.
     * @param user The user to be added to the subscription list.
     */
    public void subscribe(LibraryItem a, User b){
        if(!subscribers.containsKey(a)){ //if item does not have a waitlist
            List <User> users = new ArrayList<>(); //create a new waitlist for the item
            users.add(b); //add the user to the waitlist
            subscribers.put(a, users); //add the item and the waitlist to the subscribers hashmap
            System.out.print("The user ");
           System.out.print(b.getName());
            System.out.print(" was added to the waitlist for item ");
            System.out.println(a.getTitle());
        }
        subscribers.get(a).add(b); //add the user to the waitlist for the item
    }

    /**
     * Unsubscribes a user from a specific library item.
     *
     * @param item The library item the user wants to unsubscribe from.
     * @param user The user to be removed from the subscription list.
     */
    public void unsubscribe(LibraryItem a, User b){
       try {
        subscribers.get(a).remove(b); //remove the user from the waitlist for the item
        System.out.print("The user ");
        System.out.print(b.getName());
        System.out.print(" was removed from the waitlist for item ");
        System.out.println(a.getTitle());  
       } catch (Exception e) {
        System.out.println("There is no one on the waitlist.");
       }
       
        
    }

    /**
     * Notifies the next user in the waitlist for a specific library item and removes them from the list.
     *
     * @param item The library item that is now available.
     */
   public void update (LibraryItem a){
    try {
    queue = subscribers.get(a); //create a variable to store the waitlist for the specific item
     queueUser = queue.get(0); //get the first user in the waitlist for the item
    queueUser.notify(a); //notify the user that the item is available to reserve
   //unsubscribe(a, queueUser); //unsubscribe the user from the waitlist for the item
    } catch (Exception e) {
       System.out.println("No users to notify.");
    }
   
   }
}
