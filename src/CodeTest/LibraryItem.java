package CodeTest;


	import java.time.LocalDate;

	/**
	 * An abstract class representing a generic item in the library.
	 */
	public abstract class LibraryItem {

	    /** The title of the item. */
	    private String title;

	    /** The author or creator of the item. */
	    private String author;

	    /** The year the item was published. */
	    private int publicationYear;
	    
	    /** The age rating of items. */
	    private int ageRating;

	    /** Indicates if the item is currently borrowed. */
	    protected boolean isBorrowed = false;

	    /** The due date for the borrowed item. */
	    protected LocalDate dueDate = null;

	    /**
	     * Constructs a new LibraryItem with the specified title, author, and
	     * publication year.
	     *
	     * @param title           The title of the item.
	     * @param author          The author of the item.
	     * @param publicationYear The year the item was published.
	     */
	    public LibraryItem(String title, String author, int publicationYear, int ageRating) {
	        this.title = title;
	        this.author = author;
	        this.publicationYear = publicationYear;
	        this.ageRating = ageRating;
	    }

	    /**
	     * Gets the title of the item.
	     *
	     * @return The title.
	     */
	    public String getTitle() {
	        return title;
	    }
	    
	    /**
	     * Gets the age rating of the item.
	     *
	     * @return The age rating.
	     */
	    public int getAgeRating() {
	    	return ageRating;
	    }

	    /**
	     * Gets the author of the item.
	     *
	     * @return The author.
	     */
	    public String getAuthor() {
	        return author;
	    }

	    /**
	     * Gets the publication year of the item.
	     *
	     * @return The publication year.
	     */
	    public int getPublicationYear() {
	        return publicationYear;
	    }

	    /**
	     * An abstract method to get the details of the item.
	     *
	     * @return A string containing the item's details.
	     */
	    public abstract String getDetails();
	}

