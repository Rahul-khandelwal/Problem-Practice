/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problemsolving.java;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * Find K largest file names from a given directory.
 * 
 * @author Rahul
 */
public class KLargestFileNames {
   
    public List<String> find(int k, String rootDir) {
        TreeSet<String> output = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.valueOf(o2.length()).compareTo(o1.length());
            }
        });
        
        this.findKLargestFileNames(k, new File(rootDir), output);
        return new ArrayList<>(output);
    }
    
    private void findKLargestFileNames(int k, File dir, TreeSet<String> output) {
        if (dir.isDirectory()) {
            for (File f : dir.listFiles()) {
                this.findKLargestFileNames(k, f, output);
            }
        } else {
            output.add(dir.getName());
            if (output.size() > k) {
                output.remove(output.last());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new KLargestFileNames().find(2, "X:\\Interview_Experience"));
    }
}
