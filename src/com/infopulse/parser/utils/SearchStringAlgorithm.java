package com.infopulse.parser.utils;

public class SearchStringAlgorithm {

    //Knuth-Morris-Pratt
    public static int searchMKP(char[] str, char[] subStr, int beginIndex) {
        int[] prf = prefixMKP(subStr);

        for (int j = 0, i = beginIndex; i < str.length; ++i){
            while ((j>0) && (subStr[j] != str[i])) {
                j = prf[j-1];
            }

            if (subStr[j] == str[i]) {
                j++;
            }

            if (j==subStr.length) {
                return (i-subStr.length+1);
            }
        }

        return -1;
    }

    private static int[] prefixMKP(char[] str) {
        int len = str.length;
        int[] prf = new int[len];

        for (int j = 0, i = 1; i < len; ++i) {
            while((j > 0) && (str[i] != str[j])) {
                j = prf[j-1];
            }

            if (str[i] == str[j]) {
                j++;
            }

            prf[i] = j;
        }

        return prf;
    }
}
