package strategyPattern;

import java.util.List;

import CodeTest.LibraryItem;

public interface SearcherStrategy {
	List<LibraryItem> search(String type, List<LibraryItem> listShelf);
}
