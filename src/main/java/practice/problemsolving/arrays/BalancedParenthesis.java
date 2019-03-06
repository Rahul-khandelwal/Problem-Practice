/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problemsolving.arrays;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Rahul
 */
public class BalancedParenthesis {
    
    /**
     * Time complexity - O(n)
     * Space complexity - O(n)
     * @param input
     * @return 
     */
    public boolean isBalanced(String input) {
        if (input == null || input.isBlank()) {
            return true;
        }
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : input.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char counterPart = stack.pop();
                if ((counterPart == '(' && c == ')') || 
                        (counterPart == '{' && c == '}') || 
                        (counterPart == '[' && c == ']')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    /**
     * Time complexity - O(3n)
     * Space complexity - O(1)
     * @param input
     * @return 
     */
    public boolean isBalancedSpaceEfficient(String input) {
        if (input == null || input.isBlank()) {
            return true;
        }
        
        Set<Character> otherOpening = new HashSet<>();
        Set<Character> otherClosing = new HashSet<>();
        // Check validity of ( and ) pair
        otherOpening.add('{');
        otherOpening.add('[');
        otherClosing.add('}');
        otherClosing.add(']');
        if (!isBalancedForOneType(input, '(', ')', otherOpening, otherClosing)) {
            return false;
        }
        
        // Check validity of { and } pair
        otherOpening.clear();
        otherClosing.clear();
        otherOpening.add('(');
        otherOpening.add('[');
        otherClosing.add(')');
        otherClosing.add(']');
        if (!isBalancedForOneType(input, '{', '}', otherOpening, otherClosing)) {
            return false;
        }
        
        // Check validity of [ and ] pair
        otherOpening.clear();
        otherClosing.clear();
        otherOpening.add('{');
        otherOpening.add('(');
        otherClosing.add('}');
        otherClosing.add(')');
        if (!isBalancedForOneType(input, '[', ']', otherOpening, otherClosing)) {
            return false;
        }
        
        return true;
    }
    
    private boolean isBalancedForOneType(String input, char opening, char closing, 
            Set<Character> otherOpening, Set<Character> otherClosing) {
        int count = 0;
        int otherCount = 0;
        
        for (char c : input.toCharArray()) {
            if (c == opening) {
                count++;
                otherCount = 0; // reset
            } else if (c == closing) {
                if (count == 0 || otherCount != 0) {
                    return false;
                }
                
                count--;
            } else if (otherOpening.contains(c)) {
                otherCount++;
            } else if (otherClosing.contains(c)) {
                otherCount--;
            }
        }
        
        return count == 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new BalancedParenthesis().isBalanced("{()}[]"));
        System.out.println(new BalancedParenthesis().isBalancedSpaceEfficient("{()}[]"));
        System.out.println(new BalancedParenthesis().isBalanced("{({)}}[]"));
        System.out.println(new BalancedParenthesis().isBalancedSpaceEfficient("{({)}}[]"));
    }
    
}
