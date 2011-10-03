package com.infopulse.parser.utils;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Hash {
    public static int hashCode(char[] chrs, int startIndex, int length) {
        HashCodeBuilder hcb = new HashCodeBuilder(17, 37);

        for(int i = startIndex; i <(length + startIndex); i++) {
               hcb.append(chrs[i]);
        }

        return hcb.toHashCode();
    }
}
