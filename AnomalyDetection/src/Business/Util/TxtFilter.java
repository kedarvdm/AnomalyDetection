/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Util;

import java.io.File;

/**
 *
 * @author Sonam
 */
public class TxtFilter extends javax.swing.filechooser.FileFilter {

    public boolean accept(File f) {

        return f.isFile() && f.getName().toLowerCase().endsWith(".txt");
    }

    public String getDescription() {
        return "*.txt";
    }
}
