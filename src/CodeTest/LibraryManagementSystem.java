package CodeTest;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import CompositePattern.TaskContext;
import CompositePattern.UserRole;
import strategyPattern.CompositeSearchStrategy;
import strategyPattern.PartialSearchStrategy;
import strategyPattern.SearchByAge;
import strategyPattern.SearchByAuthor;
import strategyPattern.SearchByISBN;
import strategyPattern.SearchByPublicationYear;
import strategyPattern.SearchByTitle;
import strategyPattern.SearchContext;

/**
 * The main class for the Library Management System.
 * Handles user interactions and library operations.
 */
public class LibraryManagementSystem {

    /**
     * The entry point of the application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Initialize the library
        Library library = new Library();

        // Initialize library items
        initializeLibraryItems(library);
        
        Map<String, UserRole> userRoles = initializeRolesAndPermissions();

        // Initialize users
        Map<String, User> users = initializeUsers(userRoles);

        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // User login
        User currentUser = userLogin(scanner, users);

        // If login failed, exit the program
        if (currentUser == null) {
            scanner.close();
            return;
        }

        // Main interaction loop
        mainMenuLoop(scanner, library, currentUser, userRoles);

        // Close the scanner
        scanner.close();
    }

    /**
     * Initializes the library with sample books and magazines.
     *
     * @param library The library to add items to.
     */
    private static void initializeLibraryItems(Library library) {
        // Create books
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 12, "1234567890");
        Book book2 = new Book("1984", "George Orwell", 1949, 17, "0987654321");

        // Create magazines
        Magazine magazine1 = new Magazine("Time", "Henry Luce", 5, 2021, 15);
        Magazine magazine2 = new Magazine("National Geographic", "Various", 2022, 9, 101);

        // Add items to the library
        library.addItem(book1);
        library.addItem(book2);
        library.addItem(magazine1);
        library.addItem(magazine2);
    }
    
    private static Map<String, UserRole> initializeRolesAndPermissions() {
        Map<String, UserRole> roles = new HashMap<>();

        // Define roles
        UserRole librarian = new UserRole("Librarian");
        librarian.assignTask("addItem");
        librarian.assignTask("removeItem");
        librarian.assignTask("listAllItems");

        UserRole member = new UserRole("Member");
        member.assignTask("borrowItem");
        member.assignTask("returnItem");
        member.assignTask("listBorrowableItems");

        UserRole admin = new UserRole("Admin");
        admin.assignTask("manageRoles");
        admin.assignTask("addItem");
        admin.assignTask("removeItem");
        admin.assignTask("listAllItems");

        roles.put("librarian", librarian);
        roles.put("member", member);
        roles.put("admin", admin);
        return roles;
    }

    /**
     * Initializes the users for the system.
     *
     * @return A map of usernames to User objects.
     */
    private static Map<String, User> initializeUsers(Map<String, UserRole> roles) {
        Map<String, User> users = new HashMap<>();
        users.put("alice", new User("Alice", roles.get("member")));
        users.put("wendy", new User("Wendy", roles.get("librarian")));
        users.put("olivia", new User("Olivia", roles.get("admin")));
        return users;
    }

    /**
     * Handles the user login process.
     *
     * @param scanner Scanner for user input.
     * @param users   Map of available users.
     * @return The logged-in User object or null if login failed.
     */
    private static User userLogin(Scanner scanner, Map<String, User> users) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine().toLowerCase();
        User currentUser = users.get(username);

        if (currentUser == null) {
            System.out.println("User not found");
            return null;
        }
        return currentUser;
    }

    /**
     * Displays the main menu and processes user choices.
     *
     * @param scanner     Scanner for user input.
     * @param library     The library instance.
     * @param currentUser The logged-in user.
     */
    private static void mainMenuLoop(Scanner scanner, Library library, User currentUser, Map<String, UserRole> roles) {
        boolean quit = false;

        while (!quit) {
            displayMenu(currentUser.getRole());

            System.out.print("Choose an option: ");
            int option;

            try {
                option = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume invalid input
                continue;
            }

            quit = processMenuOption(option, scanner, library, currentUser, roles);
        }
    }

    /**
     * Displays the menu options based on the user's permissions.
     *
     * @param currentUser The logged-in user.
     */
    private static void displayMenu(UserRole role) {
        System.out.println("\nLibrary Management System");
        System.out.println("1. Search for an item");
        if (role.hasPermission("borrowItem")) System.out.println("2. Borrow an item");
        if (role.hasPermission("returnItem")) System.out.println("3. Return an item");
        if (role.hasPermission("listBorrowableItems")) System.out.println("4. List borrowable items");
        if (role.hasPermission("addItem")) System.out.println("5. Add an item");
        if (role.hasPermission("removeItem")) System.out.println("6. Remove an item");
        if (role.hasPermission("listAllItems")) System.out.println("7. List all items");
        System.out.println("0. Quit");
    }

    /**
     * Processes the user's menu option.
     *
     * @param option      The menu option selected.
     * @param scanner     Scanner for user input.
     * @param library     The library instance.
     * @param currentUser The logged-in user.
     * @return True if the user chooses to quit; false otherwise.
     */
    private static boolean processMenuOption(int option, Scanner scanner, Library library, User currentUser, Map<String, UserRole> roles) {
    	UserRole role = currentUser.getRole();
        switch (option) {
            case 1:
                runSearchStrategy(scanner, library);
                break;
            case 2:
            	runTask("borrowItem", scanner, library, currentUser, role);
                break;
            case 3:
            	runTask("returnItem", scanner, library, currentUser, role);
                break;
            case 4:
            	runTask("listBorrowableItems", scanner, library, currentUser, role);
                break;
            case 5:
            	runTask("addItem", scanner, library, currentUser, role);
                break;
            case 6:
            	runTask("removeItem", scanner, library, currentUser, role);
                break;
            case 7:
            	runTask("listAllItems", scanner, library, currentUser, role);
                break;
            case 0:
                System.out.println("Goodbye, " + currentUser.getName() + "!");
                return true;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
        return false;
    }

    private static void runTask(String task, Scanner scanner, Library library, User currentUser, UserRole role) {
    	TaskContext context = new TaskContext(currentUser);

        if (role.hasPermission(task)) {
            role.runTask(task, context);

            // Placeholder for task-specific logic
            switch (task) {
                case "addItem":
                    addItem(scanner, library);
                    break;
                case "removeItem":
                    removeItem(scanner, library);
                    break;
                case "listAllItems":
                    library.listAllItems();
                    break;
                case "borrowItem":
                    borrowItem(scanner, library, currentUser);
                    break;
                case "returnItem":
                    returnItem(scanner, library, currentUser);
                    break;
                case "listBorrowableItems":
                    library.listBorrowableItems();
                    break;
            }
        } else {
            System.out.println("You do not have permission to perform this task.");
        }
    }
    
    private static void runSearchStrategy(Scanner scanner, Library library) {
       	SearchContext context = new SearchContext();//no strategy currently
       	
    	System.out.println("\nYour search methods");
    	System.out.println("1. Search by title");
    	System.out.println("2. Search by author");
    	System.out.println("3. Search by publication year");
    	System.out.println("4. Search by age rating");
    	System.out.println("5. Search by ISBN");
    	System.out.println("6. Partial search");
    	System.out.println("7. Composite search");
    	System.out.println("0. Quit");
    	System.out.print("Choose an option: ");
    	
    	int searchChoice = scanner.nextInt();
    	scanner.nextLine();
    	if(searchChoice == 0) {
    		return;
    	}
    	System.out.print("Enter your search :");
    	String userChoice = scanner.nextLine();
    	
    	//give context a strategy
    	switch(searchChoice) {
    		case 1:
    			context.setStrategy(new SearchByTitle());
    			break;
    		case 2:
    			context.setStrategy(new SearchByAuthor());
    			break;
    		case 3:
    			context.setStrategy(new SearchByPublicationYear());
    			break;
    		case 4:
    			context.setStrategy(new SearchByAge());
    			break;
    		case 5:
    			context.setStrategy(new SearchByISBN());
    			break;
    		case 6:
    			context.setStrategy(new PartialSearchStrategy(item -> item.getTitle() + " " + item.getAuthor()));
    			break;
    		case 7:
    			CompositeSearchStrategy compositeSearch = new CompositeSearchStrategy();
    			compositeSearch.addStrategy(new SearchByTitle());
    			compositeSearch.addStrategy(new SearchByAuthor());
    			context.setStrategy(compositeSearch);
    			break;
    		default:
    			System.out.println("Invalid option. Please try again.");
                break;	
    	}
    	
    	List<LibraryItem> found = context.runSearch(userChoice, library.getItems());
    	
    	if (found.isEmpty()) {
            System.out.println("No items found.");
        } else {
            System.out.println("Search results:");
            for(LibraryItem item : found) {
            	System.out.println(item.getDetails());
            }
        }
    }

    /**
     * Allows the user to borrow an item.
     *
     * @param scanner     Scanner for user input.
     * @param library     The library instance.
     * @param currentUser The logged-in user.
     */
    private static void borrowItem(Scanner scanner, Library library, User currentUser) {
    	System.out.print("Enter the title of the item to borrow: ");
        String borrowTitle = scanner.nextLine();
        
        SearchContext context = new SearchContext();
        context.setStrategy(new SearchByTitle());
        List<LibraryItem> result = context.runSearch(borrowTitle, library.getItems());
        
        if (!result.isEmpty()) {
        	LibraryItem itemToBorrow = result.get(0);
            ItemReserver.reserveItem(itemToBorrow, currentUser);
        } else {
            System.out.println("Item not found.");
        }
    }

    /**
     * Allows the user to return a borrowed item.
     *
     * @param scanner     Scanner for user input.
     * @param library     The library instance.
     * @param currentUser The logged-in user.
     */
    private static void returnItem(Scanner scanner, Library library, User currentUser) {
    	System.out.print("Enter the title of the item to return: ");
        String returnTitle = scanner.nextLine();
        
        SearchContext context = new SearchContext();
        context.setStrategy(new SearchByTitle());
        List<LibraryItem> result = context.runSearch(returnTitle, library.getItems());
        
        if (!result.isEmpty()) {
        	LibraryItem itemToReturn = result.get(0);
            ItemReserver.returnItem(itemToReturn, currentUser);
        } else {
            System.out.println("Item not found.");
        }
    }

    /**
     * Allows the user to add a new item to the library.
     *
     * @param scanner Scanner for user input.
     * @param library The library instance.
     */
    private static void addItem(Scanner scanner, Library library) {
        System.out.print("Enter the type of item to add (book/magazine): ");
        String itemType = scanner.nextLine().toLowerCase();
        System.out.print("Enter the title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the author: ");
        String author = scanner.nextLine();
        System.out.print("Enter the ageRating: ");
        int ageRating = scanner.nextInt();
        try {
            System.out.print("Enter the age rating: ");
            ageRating = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Age rating must be a number.");
            scanner.nextLine(); // Consume invalid input
            return;
        }
 
        int year;

        try {
            System.out.print("Enter the publication year: ");
            year = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Publication year must be a number.");
            scanner.nextLine(); // Consume invalid input
            return;
        }

        if ("book".equals(itemType)) {
            System.out.print("Enter the ISBN: ");
            String isbn = scanner.nextLine();
            Book newBook = new Book(title, author, year, ageRating, isbn);
            library.addItem(newBook);
        } else if ("magazine".equals(itemType)) {
            int issueNumber;
            try {
                System.out.print("Enter the issue number: ");
                issueNumber = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Issue number must be a number.");
                scanner.nextLine(); // Consume invalid input
                return;
            }
            Magazine newMagazine = new Magazine(title, author, year, ageRating, issueNumber);
            library.addItem(newMagazine);
        } else {
            System.out.println("Invalid item type.");
        }
    }

    /**
     * Allows the user to remove an item from the library.
     *
     * @param scanner Scanner for user input.
     * @param library The library instance.
     */
    private static void removeItem(Scanner scanner, Library library) {
        System.out.print("Enter the title of the item to remove: ");
        String removeTitle = scanner.nextLine();
        
        SearchContext context = new SearchContext();
        context.setStrategy(new SearchByTitle());
        List<LibraryItem> result = context.runSearch(removeTitle, library.getItems());
        
        if (!result.isEmpty()) {
        	LibraryItem itemToRemove = result.get(0);
        	library.removeItem(itemToRemove);
        } else {
            System.out.println("Item not found.");
        }
    }
}