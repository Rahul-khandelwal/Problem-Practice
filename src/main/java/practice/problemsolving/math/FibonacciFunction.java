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
public class FibonacciFunction {
    
    public static void main(String[] args) {
        System.out.println(new FibonacciFunction().fibonacciRecursive(9));
        System.out.println(new FibonacciFunction().fibonacciIterative(9));
    }
    
    /**
     * Time complexity - O(2^n)
     * Space complexity - O(n) on call stack
     * 
     * @param n
     * 
     * @return 
     */
    public int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    
    /**
     * Time complexity - O(n)
     * Space complexity - O(1)
     * 
     * @param n
     * 
     * @return 
     */
    public int fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }
        
        int lastFib = 1; // seed fib(1)
        int secondLastFib = 0; // seed fib(0)
        
        int res = 0;
        for (int i = 2 ; i <= n ; i++) {
            res = lastFib + secondLastFib;
            secondLastFib = lastFib;
            lastFib = res;
        }
        
        return res;
    }
    
}
