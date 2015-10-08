/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Route;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class Edge {
    String edgeName;
    Vertex startV;
    Vertex endV;
    ArrayList<Vertex> intersectingVertices;
    Color color;
    Double distance;
    public Edge()
    {
        intersectingVertices=new ArrayList<>();
        color= Color.ORANGE;
    }
    public String getEdgeName() {
        return edgeName;
    }

    public void setEdgeName(String edgeName) {
        this.edgeName = edgeName;
    }

    public Vertex getStartV() {
        return startV;
    }

    public void setStartV(Vertex startV) {
        this.startV = startV;
    }

    public Vertex getEndV() {
        return endV;
    }

    public void setEndV(Vertex endV) {
        this.endV = endV;
    }

    public ArrayList<Vertex> getIntersectingVertices() {
        return intersectingVertices;
    }

    public void setIntersectingVertices(ArrayList<Vertex> intersectingVertices) {
        this.intersectingVertices = intersectingVertices;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
