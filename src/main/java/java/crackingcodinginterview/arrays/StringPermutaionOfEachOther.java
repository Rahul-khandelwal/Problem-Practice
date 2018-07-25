/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.crackingcodinginterview.arrays;

/**
 * given two strings write a method to decide if one is permutation of other.
 * 
 * @author Rahul
 */
public class StringPermutaionOfEachOther {
    
    private final String input_1;
    private final String input_2;

    public StringPermutaionOfEachOther(String input_1, String input_2) {
        this.input_1 = input_1;
        this.input_2 = input_2;
    }
    
    public boolean isPermutation() {
        char [] arr_1 = this.input_1.toCharArray();
        char [] arr_2 = this.input_2.toCharArray();
        
        if (arr_1.length != arr_2.length) {
            return false;
        }
        
        int [] counts = new int[128]; // ascii
        
        for (char c : arr_1) {
            counts[c]++;
        }
        
        for (char c : arr_2) {
            counts[c]--;
            
            if (counts[c] < 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new StringPermutaionOfEachOther("test", "este").isPermutation());
    }
}
