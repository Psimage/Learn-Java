package com.infopulse.parser.utils;

import java.util.ArrayList;

public class Tree<T> {
	private T value;
	public ArrayList<Tree<T>> subTrees = new ArrayList<Tree<T>>();

	public T getValue() {
		return value;
	}

	public void setValue(T newValue) {
		value = newValue;
	}

	public void addSubTree(Tree<T> newSubTree) {
		subTrees.add(newSubTree);
	}

    public final ArrayList<Tree<T>> getSubtreeList() { return subTrees; }
}
