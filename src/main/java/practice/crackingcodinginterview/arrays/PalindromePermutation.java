/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.crackingcodinginterview.arrays;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * Permutation is rearrangement of letters and palindrome need not to be limited to dictionary words.
 * 
 * @author Rahul
 */
public class PalindromePermutation {
    
    private static final int a_index = Character.getNumericValue('a');
    private static final int z_index = Character.getNumericValue('z');
    private static final int A_index = Character.getNumericValue('A');
    private static final int Z_index = Character.getNumericValue('Z');
    
    private final String input;

    public PalindromePermutation(String input) {
        this.input = input;
    }
    
    /**
     * This method checks only for letters and it is case insensitive.
     * 
     * @return 
     */
    public boolean isPalindromePermutation() {
        int [] counts = new int[z_index - a_index + 1];
        int oddCount = 0;
        
        for (char c : this.input.toCharArray()) {
            int index = this.getIndexForChar(c);
            counts[index] ++;
            
            if (counts[index] % 2 == 0) {
                oddCount --;
            } else {
                oddCount ++;
            }
        }
        
        return oddCount <= 1;
    }
    
    private int getIndexForChar(char _c) {
        int charInt = Character.getNumericValue(_c);
        
        if (charInt >= a_index && charInt <= z_index) {
            return charInt - a_index;
        } else if (charInt >= A_index && charInt <= Z_index) {
            return charInt - A_index;
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(new PalindromePermutation("ababc").isPalindromePermutation());
    }
}
