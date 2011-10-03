package com.infopulse.parser;

import java.util.ArrayList;
import com.infopulse.parser.operators.Operation;
import com.infopulse.parser.rules.Rule;
import com.infopulse.parser.utils.Tree;

public class Parser {
	private Tree<?> tree = new Tree<Object>();
	private String	parseStr;

	public <T> Tree<?> add(T node, Tree<?> localTree) {
		Tree<T> newTree = new Tree<T>();
		newTree.setValue(node);

		if(localTree == null) {
			tree.addSubTree(newTree);
		} else {
			localTree.addSubTree(newTree);
		}
		return newTree;
	}

	public <T> Tree<?> add(T node) {
		Tree<T> newTree = new Tree<T>();
		newTree.setValue(node);
		tree.addSubTree(newTree);

		return newTree;
	}
/*
	public String Parse(String str, Rule rule) {
		if(str!=null && rule!=null && str.length()>0)
			return rule.perfomRule(str);

		System.out.println("Bad things happened in Parser :(");
		return null;
	}
*/
	public String Parse(String str) {
		if(str!=null && str.length()>0) {
			parseStr = str;
			return performTree(tree.subTrees.get(0));
		}

		return null;
	}

	private String performTree(Tree<?> localTree) {
		ArrayList<String> strs = new ArrayList<String>();

		for (Tree<?> nextTree: localTree.subTrees) {
			strs.add(
				performTree(
					nextTree));
		}

		if(strs.size()>1) {
			return ((Operation)(localTree.getValue())).
					performOperation(strs);
		} else if(strs.size()!=0) {
			return ((Rule)(localTree.getValue())).performRule(strs.get(0));
		} else {
			return ((Rule)(localTree.getValue())).performRule(parseStr);
		}
	}
}
