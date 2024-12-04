package strategyPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import CodeTest.LibraryItem;

public class PartialSearchStrategy implements SearcherStrategy {
	private Function<LibraryItem, String> extractor; 
	public PartialSearchStrategy(Function<LibraryItem, String> extractor) {
		this.extractor = extractor;
	}
	@Override
	public List<LibraryItem> search(String type, List<LibraryItem> listShelf){
		List<LibraryItem> found = new ArrayList<>();
		String value;
		for(LibraryItem item: listShelf) { 
			value = extractor.apply(item);
			if(value != null && value.toLowerCase().contains(type.toLowerCase())){
				found.add(item);
			}			
		}
		return found;
	}	
}

