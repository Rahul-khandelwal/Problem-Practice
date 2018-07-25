/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.problemsolving.arrays;

/**
 * Given a string, find the longest substring which is palindrome. 
 * For example, if the given string is “forgeeksskeegfor”, the output should be “geeksskeeg”.
 * 
 * @author Rahul
 */
public class LongestPalindromicSubstring {
    
    /**
     * This is the best solution to get the longest palindromic substring.
     * The idea is to get all even and odd length palindromes for every index in string.
     * To get odd length palindromes we can consider index as the middle of palindrome.
     * To get even length palindromes we can consider index and index - 1 as the two centers of palindrome.
     * 
     * Time complexity is O(n^2)
     * Space complexity is O(1)
     * 
     * @param _input
     * 
     * @return 
     */
    public String getLongestPalindromeSubstring(String _input) {
        String longestPalindrome = "";
        
        char[] chars = _input.toCharArray();
        
        for (int i = 1 ; i < chars.length ; i++) {
            
            // check for even length palindromes
            // center of palindrom are i and i - 1
            int low = i - 1;
            int high = i;
            
            while (low >= 0 && high < chars.length && chars[low] == chars[high]) {
                --low;
                ++high;
            }
            
            if (high != i) {
                // we ran through the loop, so reduce the low and high value before the state of loop break
                low++;
                high--;
            }
            
            if (high - low + 1 > longestPalindrome.length()) {
                longestPalindrome = _input.substring(low, high + 1);
            } 
            
            // check the longest odd palindrome with center point as i
            low = i - 1;
            high = i + 1;
                    
            while (low >= 0 && high < chars.length && chars[low] == chars[high]) {
                 --low;
                ++high;
            }
            
            if (high != i + 1) {
                // we ran through the loop, so reduce the low and high value before the state of loop break
                low++;
                high--;
            }
            
            if (high - low + 1 > longestPalindrome.length()) {
                longestPalindrome = _input.substring(low, high + 1);
            } 
        }
        
        return longestPalindrome;
    }
    
    /**
     * This is the dynamic programming solution to get the longest palindromic substring.
     * The idea is to store the solution of subproblems and use them.
     * 
     * Time complexity is O(n^2)
     * Space complexity is O(n^2)
     * 
     * TODO Implement the solution
     * 
     * @param _input
     * 
     * @return 
     */
    public String getLongestPalindromeSubStrDynamicProgramming(String _input) {
        String longestPalindrome = "";
        return longestPalindrome;
    }

    
    /**
     * This is the simplest solution to get the longest palindromic substring.
     * The idea is to get all substrings of given string and check them all for palindrome.
     * 
     * Time complexity is O(n^3)
     * Space complexity is O(1)
     * 
     * @param _input
     * 
     * @return 
     */
    public String getLongestPalindromeSubstrSimple(String _input) {
        String longestPalindrome = "";
        
        char[] chars = _input.toCharArray();
        
        for (int i = 0 ; i < chars.length ; i++) {
            
            for (int j = i + 2 ; j < chars.length ; j++) { // starting from i + 2 instead of i + 1 as we need minimum two length substring
                // substring is between i and j, check for this to be palindrome
                int low = i;
                int high = j;
                boolean palindrome = true;
                while (low < high) {
                    if (chars[low] != chars[high]) {
                        palindrome = false;
                        break;
                    }
                    
                    low++;
                    high--;
                }
                
                if (palindrome && j - i + 1 > longestPalindrome.length()) {
                    longestPalindrome = _input.substring(i, j + 1);
                }
            }
        }
        
        return longestPalindrome;
    }
    
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().getLongestPalindromeSubstrSimple("forgeeksskeegfor"));
    }
}
