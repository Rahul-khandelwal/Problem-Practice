/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problemsolving.arrays;

import java.util.*;

/**
 * https://www.spoj.com/problems/AGGRCOW/
 * 
 * This problem is a variation of binary search.
 * 
 * @author Rahul
 */
public class AggresiveCows {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            int stalls = sc.nextInt();
            int cows = sc.nextInt();

            int[] locations = new int[stalls];

            for (int j = 0; j < stalls; j++) {
                locations[j] = sc.nextInt();
            }

            // Sort the locations
            Arrays.sort(locations);

            int startPos = 0;
            int lastPos = locations[stalls - 1];
            int distance = -1;

            while (startPos <= lastPos) {
                // Get the location at mid point
                int dist = (startPos + lastPos) / 2;

                // check if calculated distance can be used
                if (canPlaceAtDistance(locations, dist, cows)) {
                    // update the distance and try for larger distance by updating start point
                    if (dist > distance) {
                        distance = dist;
                    }
                    startPos = dist + 1;
                } else {
                    // try for smaller distance by updating end point
                    lastPos = dist - 1;
                }
            }

            System.out.println(distance);
        }
    }

    private static boolean canPlaceAtDistance(int[] locations, int distance, int cows) {
        int cowsPlaced = 1;
        int currLoc = locations[0];

        for (int i = 1; i < locations.length; i++) {
            if (locations[i] - currLoc >= distance) {
                cowsPlaced++;
                currLoc = locations[i];
            }

            if (cowsPlaced == cows) {
                return true;
            }
        }

        return false;
    }
}
