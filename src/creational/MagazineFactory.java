package creational;

import CodeTest.Magazine;


/**
 * Factory class for creating Magazine objects.
 * Implements the CreateItem interface to comply with the generic factory structure.
 * This class encapsulates the logic for creating Magazine objects.
 */

public class MagazineFactory implements CreateItem{
	private String title;
	private int publicationYear;
	private String author;
	private int ageRating;
    private int issueNumber;
	
    /**
     * Constructor for MagazineFactory.
     *
     * @param title           The title of the magazine.
     * @param author          The author or editor of the magazine.
     * @param publicationYear The year the magazine was published.
     * @param ageRating       The age rating for the magazine.
     * @param issueNumber     The issue number of the magazine.
     */

    public MagazineFactory (String title, String author, int publicationYear, int ageRating, int issueNumber) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.author = author;
        this.ageRating = ageRating;
        this.issueNumber = issueNumber;
	}
    
    /**
     * Creates a new Magazine object with the specified attributes.
     * This method adheres to the CreateItem interface contract.
     *
     * @return A new instance of Magazine.
     */
    
    @Override
     public Magazine createItem() {
        Magazine newMagazine = new Magazine(title, author, publicationYear, ageRating, issueNumber);
        return newMagazine;
    }
}
