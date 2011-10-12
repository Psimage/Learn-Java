package com.infopulse.parser;

import com.infopulse.parser.rules.Rule;
import com.infopulse.parser.utils.Tree;

public class RuleNode {
    Tree<Object> tree = null;

    RuleNode(Tree<Object> tree) {
        this.tree = tree;
    }

    Tree<Object> getTree() {
        return tree;
    }

    void setTree(Tree<Object> tree) {
        this.tree = tree;
    }
}
