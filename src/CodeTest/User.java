package CodeTest;

import CompositePattern.UserRole;

public class User {

    /** The name of the user. */
    private String name;

    /** The role of the user. */
    private UserRole role; // "librarian", "admin", "member", "guest"

    /**
     * Constructs a new User with the specified name and role.
     *
     * @param name The name of the user.
     * @param role The role of the user.
     */
    public User(String name, UserRole role) {
        this.name = name;
        this.role = role;
    }

    /**
     * Gets the name of the user.
     *
     * @return The user's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the role of the user.
     *
     * @return The user's role.
     */
    public UserRole getRole() {
        return role;
    }

    /**
     * Checks if the user is a librarian.
     *
     * @return True if the user is a librarian; false otherwise.
     */
    public boolean isLibrarian() {
        return "librarian".equals(role);
    }

    /**
     * Checks if the user is an admin.
     *
     * @return True if the user is an admin; false otherwise.
     */
    public boolean isAdmin() {
        return "admin".equals(role);
    }

    /**
     * Checks if the user is a member.
     *
     * @return True if the user is a member; false otherwise.
     */
    public boolean isMember() {
        return "member".equals(role);
    }

    /**
     * Checks if the user's role is valid.
     *
     * @return True if the role is valid; false otherwise.
     */
    public boolean isValidRole() {
        return isMember() || isLibrarian() || isAdmin();
    }

    /**
     * Checks if the user has permission to borrow items.
     *
     * @return True if the user can borrow; false otherwise.
     */
    public boolean canBorrow(User user) {
        boolean borrower = true;
        if(user.role.getName().equalsIgnoreCase("admin")){
            borrower = false;
        }
        return borrower;
    }

    /**
     * Checks if the user has permission to manage items.
     *
     * @return True if the user can manage items; false otherwise.
     */
    public boolean canManageItems() {
        return isLibrarian() || isAdmin();
    }
    public void notify(LibraryItem a){ //method to notify the user on a waitlist for an item that the item is available to reserve
		System.out.println("The library item " + a.toString() + "is now available to rent.");
	}
}