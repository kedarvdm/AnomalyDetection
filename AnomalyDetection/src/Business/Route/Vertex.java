/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Route;

import Business.ID3.Record;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class Vertex {
    private int vertexId;
    private String vertexName;
    private int x;
    private int y;
    private Record weather;
    private Color color;
    private boolean isAnomalous;
    private ArrayList<Vertex> alternatives;
    
    public Vertex()
    {
        x=0;
        y=0;
        weather=null;
        color= Color.WHITE;
        alternatives= new ArrayList<>();
    }

    public int getVertexId() {
        return vertexId;
    }

    public void setVertexId(int vertexId) {
        this.vertexId = vertexId;
    }

    public String getVertexName() {
        return vertexName;
    }

    public void setVertexName(String vertexName) {
        this.vertexName = vertexName;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Record getWeather() {
        return weather;
    }

    public void setWeather(Record weather) {
        this.weather = weather;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isIsAnomalous() {
        return isAnomalous;
    }

    public void setIsAnomalous(boolean isAnomalous) {
        this.isAnomalous = isAnomalous;
    }

    public ArrayList<Vertex> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(ArrayList<Vertex> alternatives) {
        this.alternatives = alternatives;
    }
}
