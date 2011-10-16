package com.infopulse.parser;

import com.infopulse.parser.rules.Rule;

public class RuleContainer {
    public Rule rule;
    public String id;
    public Condition condition;
    String result = null;

    RuleContainer() {}

    public RuleContainer(Rule rule, String id, Condition condition) {
        this.condition = condition;
        this.rule = rule;
        this.id = id;
    }
}
