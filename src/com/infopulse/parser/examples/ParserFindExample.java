package com.infopulse.parser.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.infopulse.parser.Parser;
import com.infopulse.parser.rules.*;

public class ParserFindExample {

	public static void main(String[] args) throws IOException {
		String inLine;
		String result;

		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		Parser parser = new Parser();

		System.out.print("Add Some Text: ");
		inLine = console.readLine();

		parser.add(new FindMKP("HeHeLHlHeH"));
		result = parser.Parse(inLine);

		if(result != null)
			System.out.println("Result is \"" + result +"\"");
		else
			System.out.println("No Results.");
	}

}
