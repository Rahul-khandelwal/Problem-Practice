/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.problemsolving.math;

/**
 * There are n stairs, a person standing at the bottom wants to reach the top. 
 * The person can climb either 1 stair or 2 stairs at a time. 
 * Count the number of ways, the person can reach the top.
 * 
 * Example: Ways to climb 1 stair = 1, ways to climb 2 stairs = 2, ways to climb 3 stairs = 3, ways to climb 4 stairs = 5
 * 
 * So we can see that the answer is fibonacci(n + 1)
 * 
 * @author Rahul
 */
public class WaysToClimbStairs {
    
    public int countWays(int _stairs) {
        
        if (_stairs == 0) {
            return 0;
        }
        
        if (_stairs == 1) {
            return 1;
        }
        
        int fib_1 = 0;
        int fib_2 = 1;
        
        int ways = 0;
        
        for (int i = 2 ; i <= _stairs + 1 ; i++) {
            ways = fib_1 + fib_2;
            fib_1 = fib_2;
            fib_2 = ways;
        }
        
        return ways;
    }
    
    public static void main(String[] args) {
        System.out.println(new WaysToClimbStairs().countWays(4));
        System.out.println(new WaysToClimbStairs().countWays(2));
        System.out.println(new WaysToClimbStairs().countWays(1));
    }
    
}
