/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problemsolving.math;

/**
 *
 * @author Rahul
 */
public class NumberPairTransformation {
    
    public static void main(String[] args) {
        System.out.println(isPossible(1, 4, 5, 9));
        System.out.println(isPossible(1, 2, 3, 6));
        
        System.out.println(isPossibleDP(1, 4, 5, 9));
        System.out.println(isPossibleDP(1, 2, 3, 6));
    }

    private static boolean isPossible(int a, int b, int c, int d) {
        if (a == c && b == d) {
            return true;
        }
        
        if (a > c || b > d) {
            return false;
        }
        
        boolean aIsPossible = isPossible(a + b, b, c, d);
        
        if (aIsPossible) {
            return aIsPossible;
        }
        
        boolean bIsPossible = isPossible(a, b + a, c, d);
        
        return bIsPossible;
    }
    
    private static boolean isPossibleDP(int a, int b, int c, int d) {
        // create dp array of maximum number size
        int arraySize = c > d ? c : d;
        int [][] calcs = new int [arraySize][arraySize];
        
        // Initialize array with -1
        for (int i = 0 ; i < arraySize ; i++) {
            for (int j = 0 ; j < arraySize ; j++) {
                calcs[i][j] = -1;
            }
        }
        
        return isPossibleDP(a, b, c, d, calcs);
    }
    
    private static boolean isPossibleDP(int a, int b, int c, int d, int [][] calcs) {
        if (calcs[a - 1][b - 1] == 1) {
            return true;
        }
        
        if (calcs[a - 1][b - 1] == 0) {
            return false;
        }
        
        if (a == c && b == d) {
            // store and return
            calcs[a - 1][b - 1] = 1;
            return true;
        }
        
        if (a > c || b > d) {
            // store and return
            calcs[a - 1][b - 1] = 0;
            return false;
        }
        
        boolean aIsPossible = isPossible(a + b, b, c, d);
        
        if (aIsPossible) {
            return aIsPossible;
        }
        
        boolean bIsPossible = isPossible(a, b + a, c, d);
        
        return bIsPossible;
    } 
}
