package com.infopulse.parser.utils;

import java.util.ArrayList;

public class Tree<T> {
	private T value;
	public ArrayList<Tree<?>> subTrees = new ArrayList<Tree<?>>();

	public T getValue() {
		return value;
	}

	public void setValue(T newValue) {
		value = newValue;
	}

	public void addSubTree(Tree<?> newSubTree) {
		subTrees.add(newSubTree);
	}

	// TODO: implement bigger ingerface
}
