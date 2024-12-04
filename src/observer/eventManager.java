package observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import CodeTest.LibraryItem;
import CodeTest.User;

public class eventManager {
      public static Map<LibraryItem, List<User>> subscribers = new HashMap<>();
   public static List <User> queue = new ArrayList<>();
   public static User queueUser;

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

    public void unsubscribe(LibraryItem a, User b){
        subscribers.get(a).remove(b); //remove the user from the waitlist for the item
        System.out.print("The user ");
        System.out.print(b.getName());
        System.out.print(" was removed from the waitlist for item ");
        System.out.println(a.getTitle());
    }

   public void update (LibraryItem a){
   queue = subscribers.get(a); //create a variable to store the waitlist for the specific item
   queueUser = queue.get(0); //get the first user in the waitlist for the item
   queueUser.notify(a); //notify the user that the item is available to reserve
   //unsubscribe(a, queueUser); //unsubscribe the user from the waitlist for the item
   }
}
