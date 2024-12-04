package CompositePattern;

import CodeTest.LibraryItem;
import CodeTest.User;

public interface ActionContext {
	LibraryItem getLibraryItem();
	User getUser();
}
