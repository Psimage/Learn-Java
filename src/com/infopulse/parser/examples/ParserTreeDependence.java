package com.infopulse.parser.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.infopulse.parser.Parser;
import com.infopulse.parser.operators.OpAnd;
import com.infopulse.parser.rules.CountRule;
import com.infopulse.parser.utils.Tree;

public class ParserTreeDependence {

	public static void main(String[] args) throws IOException {
		String inLine;
		String result;
		
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		Parser parser = new Parser();
		
		System.out.print("Add Some Text: ");
		inLine = console.readLine();
		
		Tree<?> thisTree = parser.add(new CountRule("1"));
		thisTree = parser.add(new OpAnd(), thisTree);
		parser.add(new CountRule("4"), thisTree);
		parser.add(new CountRule("3"), thisTree);
		parser.add(new CountRule("bla"), thisTree);
		
		result = parser.Parse(inLine);
		
		if(result != null)
			System.out.println("Result is \"" + result +"\"");
		else
			System.out.println("No Results");
	}

}
