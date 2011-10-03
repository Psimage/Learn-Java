package com.infopulse.parser.rules;

public abstract class FindRule implements Rule {
	private String subString;

	FindRule(String subString) {
		setSubString(subString);
	}

	public final String getSubString() {
		return subString;
	}

	public void setSubString(String subString) {
		this.subString = subString;
	}

	public abstract String performRule(String inString);
}
