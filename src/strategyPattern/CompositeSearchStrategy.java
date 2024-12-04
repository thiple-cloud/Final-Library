package strategyPattern;

import java.util.ArrayList;
import java.util.List;

import CodeTest.LibraryItem;

public class CompositeSearchStrategy implements SearcherStrategy{
	private List<SearcherStrategy> strategies = new ArrayList<>();
	//add a strategy to the composite list
	public void addStrategy(SearcherStrategy strategy) {
		strategies.add(strategy);
	}
	@Override
	public List<LibraryItem> search(String type, List<LibraryItem> listShelf){
		
		List<LibraryItem> found = new ArrayList<>(listShelf);
		//run each strategy one by one
		for(SearcherStrategy strategy: strategies ) {
			try {
				List<LibraryItem> partialFound = strategy.search(type, listShelf);
				for(LibraryItem item : partialFound) {
					if(!found.contains(item)) {
						found.add(item);
					}
				}	
			} catch (Exception exception) {
				System.err.println("Error: " + strategy.getClass().getSimpleName());
				exception.printStackTrace();
			}
		}
		return found;
	}	
		
}
