/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Util;

import java.util.ArrayList;

/**
 *
 * @author Sonam
 */
public class TreeUtils {
    //Definitinos of the weather data parameters.
    public static int NUM_ATTRS = 5;
    
    public static int setSize(String set) {
        if (set.equalsIgnoreCase("Outlook")) {
            return 3;
        } else if (set.equalsIgnoreCase("Turbulence")) {
            return 2;
        } else if (set.equalsIgnoreCase("Storm")) {
            return 2;
        } else if (set.equalsIgnoreCase("Collision")) {
            return 3;
        } else if (set.equalsIgnoreCase("Deviation")) {
            return 2;
        }
        return 0;
    }

    public static String getLeafNames(int attributeNum, int valueNum) {
        //Outlook
        if (attributeNum == 0) {
            if (valueNum == 0) {
                return "Sunny";
            } else if (valueNum == 1) {
                return "Overcast";
            } else if (valueNum == 2) {
                return "Rainy";
            }
        } //Turbulence
        else if (attributeNum == 1) {
            if (valueNum == 0) {
                return "Normal";
            } else if (valueNum == 1) {
                return "Turbulent";
            }
        } //Storm
        else if (attributeNum == 2) {
            if (valueNum == 0) {
                return "No";
            } else if (valueNum == 1) {
                return "Yes";
            }
        } //Collision
        else if (attributeNum == 3) {
            if (valueNum == 0) {
                return "Low";
            } else if (valueNum == 1) {
                return "Med";
            } else if (valueNum == 2) {
                return "High";
            }
        } //Deviation
        else if (attributeNum == 4) {
            if (valueNum == 0) {
                return "No";
            } else if (valueNum == 1) {
                return "Yes";
            }
        }

        return null;
    }
    
    public static String getLeafNames(String attributeName, int valueNum) {
        //Outlook
        if (attributeName.equalsIgnoreCase("Outlook")) {
            if (valueNum == 0) {
                return "Sunny";
            } else if (valueNum == 1) {
                return "Overcast";
            } else if (valueNum == 2) {
                return "Rainy";
            }
        } //Turbulence
        else if (attributeName.equalsIgnoreCase("Turbulence")) {
            if (valueNum == 0) {
                return "Normal";
            } else if (valueNum == 1) {
                return "Turbulent";
            }
        } //Storm
        else if (attributeName.equalsIgnoreCase("Storm")) {
            if (valueNum == 0) {
                return "No";
            } else if (valueNum == 1) {
                return "Yes";
            }
        } //Collision
        else if (attributeName.equalsIgnoreCase("Collision")) {
            if (valueNum == 0) {
                return "Low";
            } else if (valueNum == 1) {
                return "Med";
            } else if (valueNum == 2) {
                return "High";
            }
        } //Deviation
        else if (attributeName.equalsIgnoreCase("Deviation")) {
            if (valueNum == 0) {
                return "No";
            } else if (valueNum == 1) {
                return "Yes";
            }
        }

        return null;
    }

    public static ArrayList<String> populateAttrMap() {
        ArrayList<String> attrMap = new ArrayList<String>();
        attrMap.add("Outlook");
        attrMap.add("Turbulence");
        attrMap.add("Storm");
        attrMap.add("Collision");
        attrMap.add("Deviation");
        return attrMap;
    }
    
    public static boolean isAttributeUsed(ArrayList<Integer> usedAttributes,int attribute) {
        if (usedAttributes.contains(attribute)) {
            return true;
        } else {
            return false;
        }
    }
}
