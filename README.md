This project was completed by:
Olivia Lin
Stanley Gee-Silverman
Lien Le
Lavanna Laass
Library Management System (LMS)
Overview

The Library Management System (LMS) is a Java-based software application designed to simplify library operations. With robust features like book and user management, role-based access control, and seamless transaction handling, LMS ensures an efficient and user-friendly experience. It is tailored for small to medium-sized libraries looking for a comprehensive and secure solution.

Key Features
1. Role-Based User Access
    Defined User Roles:
        Member: Borrow and return items, list borrowable items, search for items.
        Librarian: Manage items (add/remove), search for items, and list all items.
        Admin: Manage roles, add/remove items, list all items.
    User Login for Security:
        Only pre-registered users with authenticated accounts can access the system.
        Permissions and menu options are dynamically adjusted based on user roles.
    Legacy Adapter:
        Extend the system to manage non-standard items (e.g., DVDs, games) beyond typical library materials.

2. Comprehensive Search Strategy
    Search items flexibly using various parameters:
        Basic Criteria: Title, Author, Publication Year, Age Rating, ISBN.
        Partial Search: Find items even with incomplete details (e.g., partial titles).
        Composite Search: Combine criteria for advanced filtering (e.g., books by a specific author in a particular year).
    Results are displayed in a clear and organized format for quick identification.

3. Book and Item Management
    Add, edit, and delete library items (e.g., books, magazines, multimedia).
    Track item availability and status (issued, reserved, or available).
    Ensure seamless management of non-standard items using the legacy adapter.

4. Borrowing and Returning Items
    Allow members to borrow and return items efficiently.

5. Waitlist Notifications
    Manage waitlists for high-demand items.
    Notify users automatically when their requested item becomes available.

6. Clear and Intuitive Navigation

    Main menu dynamically adapts to the user role, displaying only relevant options.
    User-friendly interface ensures ease of use for all users.
