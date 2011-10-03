package com.infopulse.parser.rules;

import com.infopulse.parser.utils.Hash;

public class FindRabinKarp extends FindRule {
    private int findHash;

	public FindRabinKarp(String subString) {
		super(subString);
        findHash = Hash.hashCode(subString.toCharArray(), 0, subString.length());
	}

	public String performRule(String inString) {
        int inHash;
        int length =inString.length()-this.getSubString().length();
        char[] inChars = inString.toCharArray();

        for(int i=0; i<=length; i++) {
            inHash = Hash.hashCode(inChars, i, this.getSubString().length());

            if((inHash == findHash)
                    && (inString.substring(i,
                    i+this.getSubString().length()).equals(this.getSubString()))) {
                return String.valueOf(i);
            }
        }

		return null;
	}
}