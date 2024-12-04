package strategyPattern;

import java.util.ArrayList;
import java.util.List;

import CodeTest.LibraryItem;

public class SearchByPublicationYear implements SearcherStrategy{
	@Override
	public List<LibraryItem> search(String type, List<LibraryItem> listShelf){
		int typeINT = Integer.parseInt(type);
		List<LibraryItem> found = new ArrayList<>();
			for(LibraryItem item: listShelf) {	
				if(item.getPublicationYear() == typeINT ) {
					found.add(item);			
				}
		}
		return found;
	}	
}
