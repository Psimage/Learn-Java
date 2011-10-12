package com.infopulse.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.infopulse.parser.rules.Rule;
import com.infopulse.parser.utils.Tree;

public class Parser {
	private Tree<Object> root = new Tree<Object>();
//    private HashMap<String, Boolean> booleanMap = new HashMap<String, Boolean>();
    private HashMap<String, String> resultMap = new HashMap<String, String>();

    public final RuleNode addRule(Rule rule, String ruleID) {
        Tree<Object> tree = new Tree<Object>();

        tree.setValue(new RuleItem(rule, ruleID));
        root.addSubTree(tree);

        return new RuleNode(tree);
    }

    public final RuleNode addRule(Rule rule, String ruleID, RuleNode node) {
        Tree<Object> tree = new Tree<Object>();

        tree.setValue(new RuleItem(rule, ruleID));
        node.getTree().addSubTree(tree);

        return new RuleNode(tree);
    }

    public Map<String, String> Parse(String str) {
        if(str!=null && str.length()>0) {
            ArrayList<Tree<Object>> list = new ArrayList<Tree<Object>>();
            root.setValue(str);
            list.add(root);
            performTree(list);
        }

        return resultMap;
    }

    private void performTree(ArrayList<Tree<Object>> treeList) {
        if(treeList.isEmpty()) return;

        ArrayList<Tree<Object>> results = new ArrayList<Tree<Object>>();

        //Перебор всех деревьев
        for (Tree<Object> tree : treeList) {
            ArrayList<Tree<Object>> subtreeList = tree.getSubtreeList();

            //Рут каждого дерева - результат его рула
            String inputData = (String) (tree.getValue());

            if (inputData != null) {

                //Перебор веток дерева
                for (Tree<Object> subtree : subtreeList) {

                    //if (condition == true)
                        //Каждая ветка дерева - рул, который нужно выполнить
                        String outputData = ((RuleItem) (subtree.getValue())).
                                rule.performRule(inputData);

                        //Сохраняем для теста результат каждого рула
                        resultMap.put(((RuleItem) (subtree.getValue())).id,
                                outputData);

                        //Теперь пусть ветка дерева держит результат своего рула
                        subtree.setValue(outputData);

                        //Формируем список сдедующих деревьев
                        results.add(subtree);
                    //endif
                }
            }
        }

        //Выполнить сдедующий увовень
        performTree(results);
    }

}

