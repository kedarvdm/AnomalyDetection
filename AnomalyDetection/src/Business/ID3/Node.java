/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.ID3;

import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class Node {
    public Link[] children;
    private ArrayList<Record> data;
    private double entropy;
    private boolean isUsed;
    private Attribute testAttribute;
    
    public Node() {
        this.data = new ArrayList<>();
        this.entropy=0.0;
        this.children=null;
        this.isUsed=false;
        this.testAttribute=new Attribute("", 0);
    }

    public Link[] getChildren() {
        return children;
    }

    public void setChildren(Link[] children) {
        this.children = children;
    }

    public ArrayList<Record> getData() {
        return data;
    }

    public void setData(ArrayList<Record> data) {
        this.data = data;
    }

    public double getEntropy() {
        return entropy;
    }

    public void setEntropy(double entropy) {
        this.entropy = entropy;
    }

    public boolean isIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    public Attribute getTestAttribute() {
        return testAttribute;
    }

    public void setTestAttribute(Attribute testAttribute) {
        this.testAttribute = testAttribute;
    }
}
