/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Util;

import Business.ID3.Attribute;
import Business.ID3.Record;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Sonam
 */
public class RouteUtils {
    public static ArrayList<Record> getSampleWeather()
    {
        //Assign random weather to vertices.
        ArrayList<Record> records= new ArrayList<>();
        ArrayList<Attribute> attributes;
        
        //Record1   Yes
        Record r= new Record();
        attributes=new ArrayList<>();
        attributes.add(new Attribute("Outlook", Attribute.Overcast));
        attributes.add(new Attribute("Turbulence", Attribute.Normal));
        attributes.add(new Attribute("Storm", Attribute.No));
        attributes.add(new Attribute("Collision", Attribute.Low));
        r.setAttributes(attributes);
        records.add(r);
        
        //Record2   No
        r= new Record();
        attributes=new ArrayList<>();
        attributes.add(new Attribute("Outlook", Attribute.Sunny));
        attributes.add(new Attribute("Turbulence", Attribute.Normal));
        attributes.add(new Attribute("Storm", Attribute.No));
        attributes.add(new Attribute("Collision", Attribute.Low));
        r.setAttributes(attributes);
        records.add(r);
        
        //Record3   Yes
        r= new Record();
        attributes=new ArrayList<>();
        attributes.add(new Attribute("Outlook", Attribute.Sunny));
        attributes.add(new Attribute("Turbulence", Attribute.Normal));
        attributes.add(new Attribute("Storm", Attribute.Yes));
        attributes.add(new Attribute("Collision", Attribute.High));
        r.setAttributes(attributes);
        records.add(r);
        
        //Record4   No
        r= new Record();
        attributes=new ArrayList<>();
        attributes.add(new Attribute("Outlook", Attribute.Sunny));
        attributes.add(new Attribute("Turbulence", Attribute.Turbulent));
        attributes.add(new Attribute("Storm", Attribute.No));
        attributes.add(new Attribute("Collision", Attribute.Med));
        r.setAttributes(attributes);
        records.add(r);
        
        
        //Record5   No
        r= new Record();
        attributes=new ArrayList<>();
        attributes.add(new Attribute("Outlook", Attribute.Rainy));
        attributes.add(new Attribute("Turbulence", Attribute.Normal));
        attributes.add(new Attribute("Storm", Attribute.No));
        attributes.add(new Attribute("Collision", Attribute.Low));
        r.setAttributes(attributes);
        records.add(r);
        
        //Record6 No
        r= new Record();
        attributes=new ArrayList<>();
        attributes.add(new Attribute("Outlook", Attribute.Rainy));
        attributes.add(new Attribute("Turbulence", Attribute.Normal));
        attributes.add(new Attribute("Storm", Attribute.Yes));
        attributes.add(new Attribute("Collision", Attribute.High));
        r.setAttributes(attributes);
        records.add(r);
        
        return records;
    }
    
    public static Record getRandomWeather(ArrayList<Record> records)
    {
        Random rand= new Random();
        int num= rand.nextInt(6);
        return records.get(num);
    } 
}
