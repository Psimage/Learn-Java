package com.infopulse.parser.rules;

import com.infopulse.parser.utils.Substring;

public class FindMKP extends FindRule {

    public FindMKP(String str) {
        super(str);
    }

    @Override
    public String performRule(String inString) {
        String result = null;

        int i = Substring.findMKP(inString.toCharArray(), getSubString().toCharArray());
        if(i != -1) {
            result = String.valueOf(i);
        }

        return result;
    }
}
