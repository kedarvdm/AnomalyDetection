/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.ID3;

/**
 *
 * @author Sonam
 */
public class Link {
    private String LinkName;
    private int linkValue;
    private Node node;
    private double decision;
    boolean isLeafLink;

    public String getLinkName() {
        return LinkName;
    }

    public void setLinkName(String LinkName) {
        this.LinkName = LinkName;
    }

    public int getLinkValue() {
        return linkValue;
    }

    public void setLinkValue(int linkValue) {
        this.linkValue = linkValue;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public double getDecision() {
        return decision;
    }

    public void setDecision(double decision) {
        this.decision = decision;
    }

    public boolean isIsLeafLink() {
        return isLeafLink;
    }

    public void setIsLeafLink(boolean isLeafLink) {
        this.isLeafLink = isLeafLink;
    }
}
