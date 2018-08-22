/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problemsolving.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.interviewbit.com/problems/3-sum-zero/
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2) 
 * 
 * @author Rahul
 */
public class SumZeroTriplets {
 
    public static void main(String[] args) {
        int [] t = { -31013930, -31013930, 9784175, 21229755 };
        ArrayList<Integer> asList = new ArrayList<>();
        
        for (int i : t) {
            asList.add(i);
        }
        
        System.out.println(threeSum(asList));
    }
    
    public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        // Sort the arraylist
        Collections.sort(A);
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        for (int i = 0 ; i < A.size() - 2 ; i++) {
            
            if (i > 0 && A.get(i).equals(A.get(i - 1))) {
                continue;
            }
            
            int left = i + 1;
            int right = A.size() - 1;
            
            while (left < right) {
                if (left != i + 1 && A.get(left).equals(A.get(left - 1))) {
                    left++;
                    continue;
                }
                if (right != A.size() - 1 && A.get(right).equals(A.get(right + 1))) {
                    right--;
                    continue;
                }
                
                int sum = A.get(i) + A.get(left) + A.get(right);
                if (sum == 0) {
                    ArrayList list = new ArrayList<Integer>(3);
                    list.add(A.get(i));
                    list.add(A.get(left));
                    list.add(A.get(right));
                    result.add(list);
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;    
                }
            }
        }
        
        return result;
    }
}
