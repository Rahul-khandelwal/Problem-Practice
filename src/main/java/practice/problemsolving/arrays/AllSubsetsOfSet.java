/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problemsolving.arrays;

/**
 * Finding all subsets of a given set in Java
 * Input: 
 * S = {a, b, c, d}
 * Output:
 * {}, {a} , {b}, {c}, {d}, {a,b}, {a,c},
 * {a,d}, {b,c}, {b,d}, {c,d}, {a,b,c}, 
 * {a,b,d}, {a,c,d}, {b,c,d}, {a,b,c,d}
 * 
 * @author Rahul
 */
public class AllSubsetsOfSet {

    void printSubsets(char set[]) {
        int n = set.length;

        // number of all subsets for set of length n is 2^n
        // Run a loop for printing all 2^n subsets one by one
        
        int totalSubsets = 1 << n;
        
        for (int i = 0; i < totalSubsets; i++) {
            System.out.print("{ ");

            // Print current subset
            for (int j = 0; j < n; j++) {
                // (1<<j) is a number with jth bit set to 1
                // so when we 'and' them with the
                // subset number (i) we get which numbers
                // are present in the subset and which
                // are not
            
                if ((i & (1 << j)) > 0) {
                    System.out.print(set[j] + " ");
                }
            }

            System.out.println("}");
        }
    }
    
    public static void main(String[] args) {
        char set[] = {'a', 'b', 'c'};
        new AllSubsetsOfSet().printSubsets(set);
    }

}
