/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problemsolving.arrays;

/**
 * https://www.geeksforgeeks.org/maximum-sum-iarri-among-rotations-given-array/
 * 
 * Given an array arr[] of n integers, 
 * find the maximum that maximizes sum of value of i*arr[i] where i varies from 0 to n-1.
 * 
 * @author Rahul
 */
public class MaximumSumAmongArrayRotations {
    
    public static void main(String[] args) {
        int arr[] = {8, 3, 1, 2};
        System.out.println(new MaximumSumAmongArrayRotations().maxSumAmongRotations(arr));
    }
    
    public int maxSumAmongRotations(int [] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        // Algo - 
        // Instead of rotating the array, we can derive sum of rotated array from current sum.
        // As all elements will be shifted to left except for first element
        // We need to subtract (sum of all element - first element) from total
        // Now the first element shifted to last index, so we need to add (first element * last index) to total
        // This will give us sum of rotated array.
        
        // Get the total of all array elements
        int arrTotal = 0;
        int refTotal = 0;
        for (int i = 0 ; i < arr.length ; i++) {
            arrTotal += arr[i];
            refTotal += (arr[i] * i);
        }
        
        int currTotal;
        int res = 0;
        for (int i = 1 ; i < arr.length ; i++) {
            currTotal = refTotal - (arrTotal - arr[i - 1]);
            currTotal += (arr[i - 1] * (arr.length - 1));
            
            res = Math.max(currTotal, res);
        }
        
        return res;
    }
}
