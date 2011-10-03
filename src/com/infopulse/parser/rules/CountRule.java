package com.infopulse.parser.rules;


public class CountRule implements Rule {
	
	protected String findStr = "";
	
	public CountRule (String str) {
		if(str!=null && str.length()>0)
			findStr = str;
		else
			System.out.println("Bad things happened in CountRule :(");
	}
	
	public String performRule(String str) {
		int counter = 0;
		int i = 0;
		
		System.out.print("Counter Rule (" + this.findStr + "): ");
		if(str == null) {
			System.out.println("null");
			return null;
		}
		
		while(true) {
			i = str.indexOf(findStr, i);
			if(i == -1) break;
			
			++i;
			++counter;
		}
		
		if(counter == 0) {
			System.out.println("null");
			return null;
		}
		
		System.out.println("count is " + counter);
		return String.valueOf(counter);
	}
}
