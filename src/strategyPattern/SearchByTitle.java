package strategyPattern;

import java.util.ArrayList;
import java.util.List;

import CodeTest.LibraryItem;

public class SearchByTitle implements SearcherStrategy {
	@Override
	public List<LibraryItem> search(String type,List<LibraryItem> listShelf){
		List<LibraryItem> found = new ArrayList<>();
		for(LibraryItem item: listShelf) {
			if(item.getTitle() != null && item.getTitle().equalsIgnoreCase(type)) {
				found.add(item);
			}
		}		
		return found;
	}
}