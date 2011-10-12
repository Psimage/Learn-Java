package com.infopulse.parser;

import com.infopulse.parser.rules.Rule;

public class RuleItem {
    public Rule rule;
    public String id;

    public RuleItem(Rule rule, String id) {
        this.rule = rule;
        this.id = id;
    }
}
