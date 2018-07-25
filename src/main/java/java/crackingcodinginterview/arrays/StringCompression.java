/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.crackingcodinginterview.arrays;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string 'aabcccccaaa' would become 'a2b1c5a3'.
 * if the compressed string would not become smaller than the original string, method should return the original string.
 * string has only uppercase and lowercase letters.
 * 
 * @author Rahul
 */
public class StringCompression {
    
    private final String input;

    public StringCompression(String input) {
        this.input = input;
    }
    
    public String compress() {
        int compressedLength = this.getCompressedInputLength();
        if (this.input.length() <= compressedLength) {
            return this.input;
        }
        
        StringBuilder builder = new StringBuilder(compressedLength);
        int consecutiveCount = 0;
        
        for (int i = 0 ; i < this.input.length() ; i++) {
            consecutiveCount++;
            
            if (i + 1 >= this.input.length() || this.input.charAt(i) != this.input.charAt(i + 1)) {
                builder.append(this.input.charAt(i)).append(consecutiveCount);
                consecutiveCount = 0;
            }
        }
        
        return builder.toString();
    }
    
    /**
     * This method returns the string length after compression.
     * This method adds another loop in solution, but second loop won't be required when compressed length is 
     * greater than input length.
     * We should discuss this tradeoff with interviewer.
     * 
     * @return 
     */
    private int getCompressedInputLength() {
        int compressedLength = 0;
        int consecutiveCount = 0;
        
        for (int i = 0 ; i < this.input.length() ; i++) {
            consecutiveCount++;
            
            if (i + 1 >= this.input.length() || this.input.charAt(i) != this.input.charAt(i + 1)) {
                compressedLength += (1 + String.valueOf(consecutiveCount).length());
                consecutiveCount = 0;
            }
        }
        
        return compressedLength;
    }
    
    public static void main(String[] args) {
        System.out.println(new StringCompression("aabcccccaaa").compress());
    }
}
