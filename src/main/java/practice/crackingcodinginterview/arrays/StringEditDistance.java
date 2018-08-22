/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.crackingcodinginterview.arrays;

/**
 * There are three types of edits that can be performed on strings: insert a char, remove a char or replace a char.
 * Given two strings, find if they are one or zero edits away.
 * 
 * @author Rahul
 */
public class StringEditDistance {
    
    private final String input_1;
    private final String input_2;

    public StringEditDistance(String input_1, String input_2) {
        this.input_1 = input_1;
        this.input_2 = input_2;
    }
    
    public boolean isEditDistanceOne() {
        // check for length first
        if (Math.abs(this.input_1.length() - this.input_2.length()) > 1) {
            return false;
        }
        
        // get the shorter and longer string
        String shorter = this.input_1.length() > this.input_2.length() ? this.input_2 : this.input_1;
        String longer = this.input_1.length() > this.input_2.length() ? this.input_1 : this.input_2;
        
        int index_1 = 0;
        int index_2 = 0;
        
        boolean diffFound = false;
        
        while (index_1 < shorter.length() && index_2 < longer.length()) {
            
            // If chars are different
            if (shorter.charAt(index_1) != longer.charAt(index_2)) {
                // If this is not first difference, then return
                if (diffFound) {
                    return false;
                }
                
                diffFound = true;
                
                if (shorter.length() == longer.length()) {
                    // case for replace, move shorter pointer
                    index_1++;
                }
                
            } else {
                // Move short pointer
                index_1++;
            }
            
            // Always move longer pointer
            index_2++;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new StringEditDistance("test", "tast").isEditDistanceOne());
    }
}
