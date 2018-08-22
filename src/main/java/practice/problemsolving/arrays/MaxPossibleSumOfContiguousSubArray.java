/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problemsolving.arrays;

/**
 * https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example:
 * Given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * For this problem, return the maximum sum.
 * 
 * Note that we'll use Kadande's algorithm for this solution.
 * Both the method implemented here are implementation of Kadane's algorithm.
 * 
 * Kadane's Algorithm
 * 
 * Initialize:
 *   max_so_far = 0
 *   max_ending_here = 0
 *
 * Loop for each element of the array
 * (a) max_ending_here = max_ending_here + a[i]
 * (b) if(max_ending_here < 0)
 *           max_ending_here = 0
 * (c) if(max_so_far < max_ending_here)
 *           max_so_far = max_ending_here
 * return max_so_far
 * 
 * Above algorithm gives the wrong answer for [-500] as it should return -500 not zero.
 * 
 * @author Rahul
 */
public class MaxPossibleSumOfContiguousSubArray {
    public static void main(String[] args) {
        int [] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSum_1(array));
        System.out.println(maxSum_2(array));
    }
    
    /**
     * Gives the wrong answer for [-500].
     * 
     * @param array
     * @return 
     */
    private static int maxSum_1(int [] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        
        int actualMax = 0;
        int currMax = 0;
        
        for (int i = 0 ; i < array.length ; i++) {
            currMax += array[i];
            
            if (currMax < 0) {
                currMax = 0;
            }
            
            if (currMax > actualMax) {
                actualMax = currMax;
            }
        }
        
        return actualMax;
    }
    
    private static int maxSum_2(int [] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        
        int actualMax = array[0];
        int currMax = array[0];
        
        for (int i = 1 ; i < array.length ; i++) {
            currMax += array[i];
            
            if (currMax < array[i]) {
                currMax = array[i];
            }
            
            if (currMax > actualMax) {
                actualMax = currMax;
            }
        }
        
        return actualMax;
    }
}

