/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.geeksforgeeks.easy;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
 * 
 * Zero sensitive paths - https://www.geeksforgeeks.org/ola-interview-experience-set-13-sde-2/
 * 
 * @author Rahul
 */
public class NumberOfPathsInMatrix {

    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
//
//        int testCases = sc.nextInt();
//
//        for (int i = 0; i < testCases; i++) {
//            int rows = sc.nextInt();
//            int columns = sc.nextInt();
//
//            int totalPaths = getNumberOfPathsDP(rows, columns);
//            System.out.println(totalPaths);
//        }

        int [][] noPath = new int [4][4];
        for (int i = 0 ; i < 4 ; i++) {
            for (int j = 0 ; j < 4 ; j++) {
                noPath[i][j] = sc.nextInt();
            }
        }
        
        int [][] path = new int [4][4];
        for (int i = 0 ; i < 4 ; i++) {
            for (int j = 0 ; j < 4 ; j++) {
                path[i][j] = sc.nextInt();
            }
        }
        
        System.out.println(getNumOfPathsZeroSensitive(noPath, 4, 4));
        System.out.println(getNumberOfPathsDPZeroSensitive(noPath, 4, 4));
        System.out.println(getNumOfPathsZeroSensitive(path, 4, 4));
        System.out.println(getNumberOfPathsDPZeroSensitive(path, 4, 4));
    }

    /**
     * Here method will invoked with last row and last column
     */
    private static int getNumberOfPaths(int currentRow, int currentColumn) {
        // If we are on either first row or first column, then there is only one possible path
        // As we can go in only one direction
        if (currentRow == 1 || currentColumn == 1) {
            return 1;
        }

        // select a path when we decrease the column ie move left
        // select another path by decreasing row ie move up
        // add both path count
        return (getNumberOfPaths(currentRow, currentColumn - 1)
                + getNumberOfPaths(currentRow - 1, currentColumn)) % (int) (Math.pow(10, 9) + 7);
    }
    
    private static int getNumOfPathsZeroSensitive(int [][] matrix, int currentRow, int currentColumn) {
        if (matrix[currentRow - 1][currentColumn - 1] == 0) {
            return 0;
        }
        
        // If we are on either first row or first column, then there is only one possible path
        // As we can go in only one direction
        if (currentRow == 1 || currentColumn == 1) {
            return 1;
        }

        // select a path when we decrease the column ie move left
        // select another path by decreasing row ie move up
        // add both path count
        return (getNumberOfPaths(currentRow, currentColumn - 1)
                + getNumberOfPaths(currentRow - 1, currentColumn));
    }

    private static int getNumberOfPathsDP(int rows, int cols) {
        // create a DP array to store output of subproblems
        int[][] subProblems = new int[rows][cols];

        // update paths to reach any cell in first column
        for (int i = 0; i < rows; i++) {
            subProblems[i][0] = 1;
        }

        // update paths to reach any cell in first row
        for (int i = 0; i < cols; i++) {
            subProblems[0][i] = 1;
        }

        // Now update the possible paths to reach any cell
        // start with second column in second row
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                // NOTE : Also add subProblems[i-1][j-1], if we want to include
                // diagonal paths as well.
                subProblems[i][j] = (subProblems[i - 1][j] + subProblems[i][j - 1])
                        % (int) (Math.pow(10, 9) + 7);
            }
        }

        // Return the counted paths for last cell
        return subProblems[rows - 1][cols - 1];
    }
    
    private static int getNumberOfPathsDPZeroSensitive(int[][] matrix, int rows, int cols) {
        // create a DP array to store output of subproblems
        int[][] subProblems = new int[rows][cols];

        // update paths to reach any cell in first column
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                break;
            }
            
            subProblems[i][0] = matrix[i][0];
        }

        // update paths to reach any cell in first row
        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == 0) {
                break;
            }
            
            subProblems[0][i] = matrix[0][i];
        }

        // Now update the possible paths to reach any cell
        // start with second column in second row
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                // NOTE : Also add subProblems[i-1][j-1], if we want to include
                // diagonal paths as well.
                if (matrix[i][j] == 0) {
                    continue;
                }
                
                subProblems[i][j] = (subProblems[i - 1][j] + subProblems[i][j - 1]);
            }
        }

        // Return the counted paths for last cell
        return subProblems[rows - 1][cols - 1];
    }
}
