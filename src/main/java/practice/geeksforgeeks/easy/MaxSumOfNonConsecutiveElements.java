/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.geeksforgeeks.easy;

import java.util.*;

/**
 * Find the max possible sum of non consecutive elements of array.
 * 
 * https://practice.geeksforgeeks.org/problems/stickler-theif/0
 * 
 * @author Rahul
 */
public class MaxSumOfNonConsecutiveElements {

    public static void main(String[] args) {
        // Read the input
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            int arraySize = sc.nextInt();

            int[] vals = new int[arraySize];

            for (int j = 0; j < arraySize; j++) {
                vals[j] = sc.nextInt();
            }

            // Calculate the output, dymanic programming will be used.
            if (arraySize == 1) {
                System.out.println(vals[0]);
                continue;
            }

            if (arraySize == 2) {
                System.out.println(vals[0] > vals[1] ? vals[0] : vals[1]);
                continue;
            }

            // Initialize an array to hold dynamic sums, start with first and second value
            int[] dpSums = new int[]{vals[0], vals[1]};

            // iterate over remaining values
            for (int j = 2; j < arraySize; j++) {
                // store the second value from DP sum array
                int temp = dpSums[1];

                // Add current value in firsr value of dpSums array and store in second index of dpSums
                dpSums[1] = dpSums[0] + vals[j];

                // update the first value in dpSums array
                dpSums[0] = Math.max(dpSums[0], temp);
            }

            // Print the max value from the DP sum array
            System.out.println(dpSums[0] > dpSums[1] ? dpSums[0] : dpSums[1]);
        }
    }
}
