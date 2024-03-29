package com.infopulse.parser.rules;

import com.infopulse.parser.utils.SearchStringAlgorithm;

public class FindMKP extends FindRule {

    public FindMKP(String str) {
        super(str);
    }

    @Override
    public String performRule(String inString) {
        String result = null;
        int i = 0;

        while(true) {
            i = SearchStringAlgorithm.searchMKP(inString.toCharArray(), getSubString().toCharArray(), i);
            if(i == -1) break;

            if(result == null)
                result = "";
            else
                result += "-";

            result += inString.substring(i, i + getSubString().length());
            i++;
        }

        return result;
    }
}
