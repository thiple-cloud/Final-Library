package strategyPattern;

import java.util.ArrayList;
import java.util.List;

import CodeTest.LibraryItem;

public class SearchByAuthor implements SearcherStrategy {
	@Override
	public List<LibraryItem> search(String type, List<LibraryItem> listShelf){
		List<LibraryItem> found = new ArrayList<>();
		for(LibraryItem item: listShelf) {
			if(item.getAuthor() !=null && item.getAuthor().equalsIgnoreCase(type)) {
				found.add(item);
			}
		}
		return found;
	}
}
