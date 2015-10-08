package Business.ID3;

import Business.Route.Edge;
import Business.Route.Route;
import Business.Route.Vertex;
import Business.Util.TreeUtils;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class RecordBuilder {

    public static ArrayList<Record> buildRecords(String path) {
        //Read text file to create decision tree.
        BufferedReader reader = null;
        DataInputStream dis = null;
        ArrayList<Record> records = new ArrayList<>();

        try {
            reader = new BufferedReader(new java.io.FileReader(path));
            // read the first record of the file
            String line;
            Record r = null;
            ArrayList<Attribute> attributes;
            while ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                attributes = new ArrayList<>();
                r = new Record();

                if (TreeUtils.NUM_ATTRS != st.countTokens()) {
                    throw new Exception("Unknown number of attributes!");
                }

                @SuppressWarnings("unused")
                String outlook = st.nextToken();
                String turbulence = st.nextToken();
                String storm = st.nextToken();
                String collision = st.nextToken();
                String deviation = st.nextToken();

                //Outlook
                if (outlook.equalsIgnoreCase("overcast")) {
                    attributes.add(new Attribute("Outlook", Attribute.Overcast));
                } else if (outlook.equalsIgnoreCase("sunny")) {
                    attributes.add(new Attribute("Outlook", Attribute.Sunny));
                } else if (outlook.equalsIgnoreCase("rainy")) {
                    attributes.add(new Attribute("Outlook", Attribute.Rainy));
                }

                //Turbulence
                if (turbulence.equalsIgnoreCase("normal")) {
                    attributes.add(new Attribute("Turbulence", Attribute.Normal));
                } else if (turbulence.equalsIgnoreCase("turbulent")) {
                    attributes.add(new Attribute("Turbulence", Attribute.Turbulent));
                }

                //Storm
                if (storm.equalsIgnoreCase("yes")) {
                    attributes.add(new Attribute("Storm", Attribute.Yes));
                } else if (storm.equalsIgnoreCase("no")) {
                    attributes.add(new Attribute("Storm", Attribute.No));

                }

                //Collision
                if (collision.equalsIgnoreCase("low")) {
                    attributes.add(new Attribute("Collision", Attribute.Low));
                } else if (collision.equalsIgnoreCase("med")) {
                    attributes.add(new Attribute("Collision", Attribute.Med));
                } else if (collision.equalsIgnoreCase("high")) {
                    attributes.add(new Attribute("Collision", Attribute.High));
                }

                //Deviation
                if (deviation.equalsIgnoreCase("no")) {
                    attributes.add(new Attribute("Deviation", Attribute.DeviationNo));
                } else if (deviation.equalsIgnoreCase("yes")) {
                    attributes.add(new Attribute("Deviation", Attribute.DeviationYes));
                }

                r.setAttributes(attributes);
                records.add(r);
            }

        } catch (IOException e) {
            System.out.println("Error reading file error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException ioe) {
                    System.out.println("Error closing file: " + ioe.getMessage());
                }
            }
        }
        return records;
    }

    public static Route buildRoute(String path, LinkedHashMap<String, Vertex> vertices) {
        //Create route edge by egde, by considering intersecting vertices.
        BufferedReader reader = null;
        DataInputStream dis = null;
        Route route = null;

        try {
            reader = new BufferedReader(new java.io.FileReader(path));
            // read the first record of the file
            String line;
            route = new Route();
            ArrayList<Edge> edges = null;
            //Line 1 route name
            if ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                if (st.countTokens() == 1) {
                    route.setRouteName(st.nextToken());
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Route Name", "Error!!!", JOptionPane.ERROR_MESSAGE);
                    return null;
                }
            }
            // Store Route
            if ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                if (st.countTokens() >= 2) {
                    edges = new ArrayList<>();
                    String token = st.nextToken();
                    Vertex current;
                    Vertex previous = vertices.get(token);
                    while (st.countTokens() > 0) {
                        token = st.nextToken();
                        //Edge e = new Edge();
                        current = vertices.get(token);
                        ArrayList<Edge> intersectingEdges= getIntersectingVertex(vertices, previous, current);
                        previous = current;
                        edges.addAll(intersectingEdges);
                        
                    }
                    route.setEdges(edges);
                } else {
                    JOptionPane.showMessageDialog(null, "At least 2 vertices needed!!", "Error!!!", JOptionPane.ERROR_MESSAGE);
                    return null;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException ioe) {
                    System.out.println("Error closing file: " + ioe.getMessage());
                }
            }
        }
        return route;
    }

    public static ArrayList<Edge> getIntersectingVertex(LinkedHashMap<String, Vertex> vertices, Vertex start, Vertex end) {
        //Check and add if there are any intersecting vertices between a direct edge
        ArrayList<Edge> edges = new ArrayList<>();
        double slope = (start.getY() - end.getY())/(double)(start.getX() - end.getX());
        double c=start.getY()-(slope*start.getX());
        Vertex current = null;
        Vertex previous = start;
        int foreRunner=0;
        int x = previous.getX();
        while (foreRunner <= end.getX()) {
            x = x + 100;
            double y = 0;
            y = slope * x + c;
            if (y % 50 == 0) {
                int pointNum = (x / 10) + ((int) y / 50);
                current = vertices.get("V" + pointNum);
                if (current != null) {
                    Edge e = new Edge();
                    e.setEdgeName(previous.getVertexName()+"-"+current.getVertexName());
                    e.setStartV(previous);
                    e.setEndV(current);
                    edges.add(e);
                    previous=current;
                }
            }
            else
            {
                continue;
            }
            foreRunner=x+100;
        }
        return edges;
    }
}
