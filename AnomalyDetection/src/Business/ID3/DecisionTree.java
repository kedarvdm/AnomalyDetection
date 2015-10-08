/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.ID3;

import Business.Util.TreeUtils;
import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class DecisionTree {

    public static ArrayList<String> attrMap;
    public static ArrayList<Integer> usedAttributes;
    public DecisionTree()
    {
        attrMap= TreeUtils.populateAttrMap();
        usedAttributes= new ArrayList<>();
    }
    public Node buildTree(ArrayList<Record> records, Node root) {
        //Build decision tree
        int bestAttribute = -1;
        double bestGain = 0;
        root.setEntropy(Entropy.calculateEntropy(root.getData()));

        if (root.getEntropy() == 0) {
            return root;
        }

        for (int i = 0; i < TreeUtils.NUM_ATTRS - 1; i++) {
            if (!TreeUtils.isAttributeUsed(usedAttributes,i)) {
                double entropy = 0;
                ArrayList<Double> entropies = new ArrayList<Double>();
                ArrayList<Integer> setSizes = new ArrayList<Integer>();

                for (int j = 0; j < TreeUtils.NUM_ATTRS - 2; j++) {
                    ArrayList<Record> subset = subset(root, i, j);
                    setSizes.add(subset.size());

                    if (!subset.isEmpty()) {
                        entropy = Entropy.calculateEntropy(subset);
                        entropies.add(entropy);
                    }
                }

                double gain = Entropy.calculateGain(root.getEntropy(), entropies, setSizes, root.getData().size());

                if (gain > bestGain) {
                    bestAttribute = i;
                    bestGain = gain;
                }
            }
        }
        if (bestAttribute != -1) {
            int setSize = TreeUtils.setSize(attrMap.get(bestAttribute));
            root.setTestAttribute(new Attribute(attrMap.get(bestAttribute), 0));
            //root.children = new Node[setSize];
            root.setChildren(new Link[setSize]);
            root.setIsUsed(true);
            this.usedAttributes.add(bestAttribute);

            for (int j = 0; j < setSize; j++) {
                root.children[j] = new Link();
                root.children[j].setNode(new Node());
                root.children[j].setLinkName(TreeUtils.getLeafNames(bestAttribute, j));
                root.children[j].setLinkValue(j);
                root.children[j].getNode().setData(subset(root, bestAttribute, j));
                root.children[j].getNode().getTestAttribute().setName(TreeUtils.getLeafNames(bestAttribute, j));
                root.children[j].getNode().getTestAttribute().setValue(j);
            }

            for (int j = 0; j < setSize; j++) {
                buildChildrenTree(root.children[j].getNode().getData(), root.children[j]);
            }
        } else {
            return root;
        }

        return root;
    }
    
    public Link buildChildrenTree(ArrayList<Record> records, Link link) {
        
        int bestAttribute = -1;
        double bestGain = 0;
        link.getNode().setEntropy(Entropy.calculateEntropy(link.getNode().getData()));

        if (link.getNode().getEntropy() == 0) {
            link.getNode().setChildren(new Link[1]);
            Link decisionLink= new Link();
            decisionLink.setLinkName("Decision");
            decisionLink.isLeafLink=true;
            decisionLink.setDecision(records.get(0).getAttributes().get(4).getValue());
            link.getNode().children[0]=decisionLink;
            return link;
        }

        for (int i = 0; i < TreeUtils.NUM_ATTRS - 1; i++) {
            if (!TreeUtils.isAttributeUsed(usedAttributes,i)) {
                double entropy = 0;
                ArrayList<Double> entropies = new ArrayList<Double>();
                ArrayList<Integer> setSizes = new ArrayList<Integer>();

                for (int j = 0; j < TreeUtils.NUM_ATTRS - 1; j++) {
                    ArrayList<Record> subset = subset(link.getNode(), i, j);
                    setSizes.add(subset.size());

                    if (!subset.isEmpty()) {
                        entropy = Entropy.calculateEntropy(subset);
                        entropies.add(entropy);
                    }
                }

                double gain = Entropy.calculateGain(link.getNode().getEntropy(), entropies, setSizes, link.getNode().getData().size());

                if (gain > bestGain) {
                    bestAttribute = i;
                    bestGain = gain;
                }
            }
        }
        if (bestAttribute != -1) {
            int setSize = TreeUtils.setSize(attrMap.get(bestAttribute));
            link.getNode().setTestAttribute(new Attribute(attrMap.get(bestAttribute), 0));
            link.getNode().children = new Link[setSize];
            link.getNode().setIsUsed(true);
            this.usedAttributes.add(bestAttribute);

            for (int j = 0; j < setSize; j++) {
                link.getNode().children[j] = new Link();
                link.getNode().children[j].setNode(new Node());
                link.getNode().children[j].setLinkName(TreeUtils.getLeafNames(bestAttribute, j));
                link.getNode().children[j].setLinkValue(j);
                link.getNode().children[j].getNode().setData(subset(link.getNode(), bestAttribute, j));
                link.getNode().children[j].getNode().getTestAttribute().setName(TreeUtils.getLeafNames(bestAttribute, j));
                link.getNode().children[j].getNode().getTestAttribute().setValue(j);
            }

            for (int j = 0; j < setSize; j++) {
                buildChildrenTree(link.getNode().children[j].getNode().getData(), link.getNode().children[j]);
            }

            link.getNode().setData(null);
        }
        return link;
    }
    

    public ArrayList<Record> subset(Node root, int attr, int value) {
        //To get subset of records after spliting
        ArrayList<Record> subset = new ArrayList<Record>();
        for (int i = 0; i < root.getData().size(); i++) {
            Record record = root.getData().get(i);

            if (record.getAttributes().get(attr).getValue() == value) {
                subset.add(record);
            }
        }
        return subset;
    }
    
    public static int getDecision(Record r, Node root)
    { 
        //Find out decision from created decision tree.
        int decision=-1;
        while(root.children!=null && decision==-1)
        {
            String attributeName="";
            String linkName="";
            for (int i = 0; i < r.getAttributes().size()-1; i++) {                                                      //Dont check decision attribute
                if(r.getAttributes().get(i).getName().equalsIgnoreCase(root.getTestAttribute().getName()))
                {
                    attributeName=r.getAttributes().get(i).getName();
                    linkName=TreeUtils.getLeafNames(r.getAttributes().get(i).getName(),r.getAttributes().get(i).getValue());
                    break;
                }
            }
            if(!attributeName.equals(""))
            {
                System.out.print(attributeName+"-->");
            }            
            if(linkName.equals(""))
            {
                linkName="Decision";
            }
            for (int i = 0; i < root.getChildren().length; i++) {
                if(linkName.equalsIgnoreCase(root.children[i].getLinkName()))
                {
                    if(root.children[i].isLeafLink)
                    {
                        System.out.print("Decision-->");
                        if(root.children[i].getDecision()==1)
                        {
                            System.out.println("Yes");
                            decision=1;
                        }
                        else
                        {
                            System.out.println("No");
                            decision=0;
                        }
                        return decision;
                    }
                    else
                    {
                        System.out.print(linkName+"-->");
                        decision=getDecision(r, root.children[i].getNode());
                    }
                }
            }
        }
        return decision;
    }
}
