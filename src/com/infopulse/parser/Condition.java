package com.infopulse.parser;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Operators;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Condition {
    private static final String LOGIC_AND = "&&";
    private static final String LOGIC_OR = "||";
    private String condition;
    private HashMap<String, Boolean> map;

    public Condition(String str, HashMap<String, Boolean> booleanMap) {
        map = booleanMap;
        condition = str;
    }

    public boolean getResult() {
        boolean result = false;
        StringTokenizer tokens = new StringTokenizer(condition, " ");

        if(tokens.countTokens()>=3) {
            String leftArgument = tokens.nextToken();
            Boolean temp = map.get(leftArgument);

            if(temp != null)
                result = true;

            String operation = tokens.nextToken();

            while(tokens.hasMoreTokens()) {
                String rightArgument = tokens.nextToken();
                temp = map.get(rightArgument);

                if(temp == null)
                    temp = false;

                if(operation.equals(LOGIC_AND))
                {
                    result = result && temp;
                    System.out.println("AND = " + result);
                }
                else if(operation.equals(LOGIC_OR))
                {
                    result = result || temp;
                    System.out.println("OR = " + result);
                }

                if(tokens.hasMoreTokens())
                    operation = tokens.nextToken();
            }
        }

        return result;
    }

}
