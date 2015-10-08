/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Route;

import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class Route {
    String routeName;
    ArrayList<Edge> edges;
    
    public Route()
    {
        edges= new ArrayList<>();
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    } 
}
