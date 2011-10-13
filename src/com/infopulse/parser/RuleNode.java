package com.infopulse.parser;

import com.infopulse.parser.rules.Rule;
import com.infopulse.parser.utils.Tree;

public class RuleNode {
    Tree<RuleContainer> tree = null;

    RuleNode(Tree<RuleContainer> tree) {
        this.tree = tree;
    }

    Tree<RuleContainer> getTree() {
        return tree;
    }

    void setTree(Tree<RuleContainer> tree) {
        this.tree = tree;
    }
}
