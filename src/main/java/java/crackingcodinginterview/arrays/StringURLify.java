/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.crackingcodinginterview.arrays;

/**
 * Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end to hold the additional characters.
 * And that you are given the 'true' length of the string.
 * 
 * @author Rahul
 */
public class StringURLify {
    
    private final String input;
    private final int trueLength;

    public StringURLify(String input, int trueLength) {
        this.input = input;
        this.trueLength = trueLength;
    }
    
    public String urlify() {
        // get the string length after urlify
        char [] input_arr = this.input.toCharArray();
        int outputLength = this.trueLength;
        for (int i = 0 ; i < this.trueLength ; i++) {
            if (input_arr[i] == ' ') {
                outputLength += 2;
            }
        }
        
        int outPointer = outputLength - 1;
        
        // copy the array elements backwards
        for (int i = trueLength - 1 ; i >= 0 ; i--) {
            if (input_arr[i] != ' ') {
                input_arr[outPointer--] = input_arr[i];
            } else {
                input_arr[outPointer--] = '0';
                input_arr[outPointer--] = '2';
                input_arr[outPointer--] = '%';
            }
        }
        
        return new String(input_arr);
    }
    
    public static void main(String[] args) {
        StringURLify uRLify = new StringURLify("mr John Smith    ", 13);
        System.out.println(uRLify.urlify());
    }
}
