/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.crackingcodinginterview.arrays;

/**
 * Assume you have a method 'isSubstring' which checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to 
 * isSubstring (e.g., 'waterbottle' is a rotation of 'erbottlewat')
 * 
 * @author Rahul
 */
public class StringRotation {
    
    private final String input;
    private final String rotation;

    public StringRotation(String input, String rotation) {
        this.input = input;
        this.rotation = rotation;
    }
    
    /**
     * if given rotated string is valid rotation of input string, then
     * rotated string will always be a substring of input + input
     * For example, 'erbottlewat' is substring of 'waterbottlewaterbottle'
     * 
     * @return 
     */
    public boolean isRotation() {
        if (this.input.length() != this.rotation.length()) {
            return false;
        }
        
        String checkFrom = this.input + this.input;
        
        int index = checkFrom.indexOf(this.rotation);
        
        return index >= 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new StringRotation("waterbottle", "erbottlewat").isRotation());
    }
}
