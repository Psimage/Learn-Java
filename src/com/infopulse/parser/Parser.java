package com.infopulse.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.infopulse.parser.rules.Rule;
import com.infopulse.parser.utils.Tree;

public class Parser {
	private Tree<RuleContainer> root = new Tree<RuleContainer>();
    private HashMap<String, Boolean> booleanMap = new HashMap<String, Boolean>();
    private HashMap<String, String> resultMap = new HashMap<String, String>();

    public Parser() {
        RuleContainer ruleContainer = new RuleContainer();
        root.setValue(ruleContainer);
    }

    public final RuleNode addRule(Rule rule, String ruleID, String strCondition) {
        Tree<RuleContainer> tree = new Tree<RuleContainer>();
        Condition condition = null;

        if(strCondition != null)
            condition = new Condition(strCondition, booleanMap);

        tree.setValue(new RuleContainer(rule, ruleID, condition));
        root.addSubTree(tree);

        return new RuleNode(tree);
    }

    public final RuleNode addRule(Rule rule, String ruleID, RuleNode node, String strCondition) {
        Tree<RuleContainer> tree = new Tree<RuleContainer>();
        Condition condition = null;

        if(strCondition != null)
            condition = new Condition(strCondition, booleanMap);

        tree.setValue(new RuleContainer(rule, ruleID, condition));
        node.getTree().addSubTree(tree);

        return new RuleNode(tree);
    }

    public Map<String, String> Parse(String str) {
        if(str!=null && str.length()>0) {
            ArrayList<Tree<RuleContainer>> list = new ArrayList<Tree<RuleContainer>>();
            root.getValue().result = str;
            list.add(root);
            performTree(list);
        }

        return resultMap;
    }

    private void performTree(ArrayList<Tree<RuleContainer>> treeList) {
        if(treeList.isEmpty()) return;

        ArrayList<Tree<RuleContainer>> results = new ArrayList<Tree<RuleContainer>>();

        //Перебор всех деревьев
        for (Tree<RuleContainer> tree : treeList) {
            ArrayList<Tree<RuleContainer>> subtreeList = tree.getSubtreeList();

            //Рут каждого дерева содержит результат его рула
            String inputData = tree.getValue().result;

            if (inputData != null) {

                //Перебор веток дерева
                for (Tree<RuleContainer> subtree : subtreeList) {

                    if(subtree.getValue().condition == null || subtree.getValue().condition.getResult()) {

                        //Каждая ветка дерева - рул, который нужно выполнить
                        String outputData = subtree.getValue().rule.performRule(inputData);

                        if(outputData != null)
                            booleanMap.put(subtree.getValue().id, true);

                        //Сохраняем для теста результат каждого рула
                        resultMap.put(subtree.getValue().id, outputData);

                        //Каждая ветка дерева содержит результат своего рула
                        subtree.getValue().result = outputData;

                        //Формируем список сдедующих деревьев
                        results.add(subtree);
                    }
                }
            }
        }

        //Выполнить сдедующий увовень
        performTree(results);
    }

}

