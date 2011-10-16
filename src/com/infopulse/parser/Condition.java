package com.infopulse.parser;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Operators;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Condition {
    private static final String LOGIC_AND = "&&";
    private static final String LOGIC_OR = "||";
    private static final String LOGIC_NOT = "!";

    private String condition;
    private HashMap<String, Boolean> map;

    public Condition(String str, HashMap<String, Boolean> booleanMap) {
        map = booleanMap;
        condition = str;
    }

    public boolean getResult() {
        System.out.println(condition);
        System.out.println(map);
        boolean result = false;
        StringTokenizer tokens = new StringTokenizer(condition, " ");

        if(tokens.hasMoreTokens()) {
            String leftArgument = tokens.nextToken();
            result = checkUnaryOp(leftArgument);
        }

        while(tokens.hasMoreTokens()) {
            String operation = tokens.nextToken();

            if(!tokens.hasMoreTokens()) break;
            String rightArgument = tokens.nextToken();
            result = checkBinaryOp(operation, result, rightArgument);
        }

        return result;
    }

    private boolean checkUnaryOp(String Argument) {
        Boolean result;

        if(Argument.startsWith(LOGIC_NOT)) {
            Argument = Argument.substring(1);
            result = map.get(Argument);

            if(result == null)
                result = false;

            result = !result;
            System.out.println("NOT(" + Argument + ") = " + result);
        }
        else {
            result = map.get(Argument);

            if(result == null)
                result = false;
        }

        return result;
    }

    private boolean checkBinaryOp(String operation, boolean result, String right) {
        boolean temp = checkUnaryOp(right);

        if(operation.equals(LOGIC_AND))
        {
            System.out.print(result + " AND " + right + " = ");
            result = result && temp;
        }
        else if(operation.equals(LOGIC_OR))
        {
            System.out.print(result + " OR " + right + " = ");
            result = result || temp;
        }

        System.out.println(result);
        return result;
    }

}
