package CompositePattern;

import CodeTest.LibraryItem;
import CodeTest.User;

public class TaskContext implements ActionContext {
	private LibraryItem libraryItem;
	private User user;
	
	public TaskContext(LibraryItem libraryItem, User user) {
		this.libraryItem = libraryItem;
		this.user = user;
	}
	
	public TaskContext(User user) {
	    this.libraryItem = null;
	    this.user = user;
	}
	
	@Override
	public LibraryItem getLibraryItem() {
		return libraryItem;
	}
	
	@Override
	public User getUser() {
		return user;
	}
	public void setLibraryItem(LibraryItem libraryItem) {
		this.libraryItem = libraryItem;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
	