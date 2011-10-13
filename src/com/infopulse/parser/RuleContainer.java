package com.infopulse.parser;

import com.infopulse.parser.rules.Rule;

public class RuleContainer {
    public Rule rule;
    public String id;
    String result = null;

    RuleContainer() {}

    public RuleContainer(Rule rule, String id) {
        this.rule = rule;
        this.id = id;
    }
}
