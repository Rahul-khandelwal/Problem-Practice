/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.crackingcodinginterview.arrays;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can't use additional data structures.
 * 
 * @author Rahul
 */
public class CheckUniqueChars {
    
    private final String input;

    public CheckUniqueChars(String _input) {
        this.input = _input;
    }
    
    public boolean hasUniqueChars() {
        boolean [] tracker = new boolean[128]; // ascii length
        
        for (char c : this.input.toCharArray()) {
            if (tracker[c]) {
                return false;
            }
            
            tracker[c] = true;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new CheckUniqueChars("abcdd").hasUniqueChars());
    }
}
