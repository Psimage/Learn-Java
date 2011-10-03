package com.infopulse.parser.operators;

import java.util.ArrayList;


public class OpAnd implements Operation{

	public String performOperation(ArrayList<String> strs) {
		String result = "";
		
		System.out.print("And operator: ");
		for(int i=0; i<strs.size(); i++) {
			if(strs.get(i) == null) {
				System.out.print("null ");
			} else {
				System.out.print(strs.get(i) + " ");
			}
		}
		System.out.print("= ");
		
		for(int i=0; i<strs.size(); i++) {
			if(strs.get(i) == null) {
				System.out.println("null");
				return null;
			} else {
				result += strs.get(i);
			}
		}
		System.out.println(result);
		return result;
	}

}
