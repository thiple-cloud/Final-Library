package strategyPattern;

import java.util.List;

import CodeTest.LibraryItem;

public class SearchContext {
	
	private SearcherStrategy strategy;
	//set a strategy
	public void setStrategy(SearcherStrategy strategy) {
		this.strategy = strategy;		
	}
	//method to run the chosen search strategy
	public List<LibraryItem> runSearch(String type, List<LibraryItem> listShelf){
		if(strategy == null) {
			throw new IllegalStateException(" no strategy found");
		} 
		return strategy.search(type, listShelf);
	}
}
