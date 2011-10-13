package com.infopulse.parser.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import com.infopulse.parser.Parser;
import com.infopulse.parser.RuleNode;
import com.infopulse.parser.rules.*;

public class ParserFindExample {

	public static void main(String[] args) throws IOException {
		String inLine;

		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		Parser parser = new Parser();

		System.out.print("Add Some Text: ");
		inLine = console.readLine();

        RuleNode node1 = parser.addRule(new FindMKP("Hello"), "R1");
            parser.addRule(new FindMKP("o"), "R2", node1);
            RuleNode node2 = parser.addRule(new FindMKP("lHe=="), "R3", node1);
                parser.addRule(new FindMKP("H"), "R4", node2);

        Map<String, String> result = parser.Parse(inLine);

		if(result != null)
			System.out.println("Result is \"" + result +"\"");
		else
			System.out.println("No Results.");
	}

}
