package strategyPattern;

import java.util.ArrayList;
import java.util.List;

import CodeTest.LibraryItem;

public class SearchByAge implements SearcherStrategy {
	//find age group by integer
	private String findAgeGroup(int age) {
		if(age>=0 && age<5) {
			return "babies";
		}else if(age>=5 && age<10){
			return "kids";
		}else if (age>=10 && age<14) {
			return "pre-teens";
		}else if (age>=14 && age<18) {
			return "teens";
		}else if (age>=18){	
			return "adults";
		}else {
			return "age cannot be negative";
		}
	}
	//check if we are within the age group
	private boolean isAgeGroup(int age, String group) {
		switch(group) {
			case "babies":
				return age>=0 && age<5;
			case "kids":
				return age>=5 && age<10;
			case "pre-teens":
				return age>=10 && age<14;
			case "teens":
				return age>=14 && age<18;
			case "adults":
				return age>=18;
			default:
				return false;			
		}
	}
	private String determineAgeGroup(String group) {
		try {
			int age;
			age = Integer.parseInt(group);
			return findAgeGroup(age);	
		} catch(NumberFormatException exception) {
			System.out.println(group + " is an invalid age. Please input a valid number.");
			return null;
		}
	}
	@Override
	public List<LibraryItem> search(String type, List<LibraryItem> listShelf){
		String group = determineAgeGroup(type);
		List<LibraryItem> found = new ArrayList<>();
		if(group == null) {
			return found;
		}
		for(LibraryItem item: listShelf) {
			if(isAgeGroup(item.getAgeRating(),group)){
				found.add(item);
			}
		}
		return found;
	}	
}