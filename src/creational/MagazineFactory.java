package creational;

import CodeTest.Magazine;

public class MagazineFactory implements CreateItem{
	private String title;
	private int publicationYear;
	private String author;
	private int ageRating;
    private int issueNumber;
	

    public MagazineFactory (String title, String author, int publicationYear, int ageRating, int issueNumber) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.author = author;
        this.ageRating = ageRating;
        this.issueNumber = issueNumber;
	}
    
    @Override
     public Magazine createItem() {
        Magazine newMagazine = new Magazine(title, author, publicationYear, ageRating, issueNumber);
        return newMagazine;
    }
}
