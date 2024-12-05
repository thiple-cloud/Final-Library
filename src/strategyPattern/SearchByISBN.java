package strategyPattern;

import java.util.ArrayList;
import java.util.List;

import CodeTest.*;

public class SearchByISBN implements SearcherStrategy{
	@Override
	public List<LibraryItem> search(String type, List<LibraryItem> listShelf){
		List<LibraryItem> found = new ArrayList<>();
			for(LibraryItem item: listShelf) {
				if(item instanceof Book) {
					Book book = (Book)item;
					if(book.getISBN() != null && book.getISBN().equalsIgnoreCase(type)) {
						found.add(item);			
					}
				}
		}
		return found;
	}	
}
