/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problemsolving.arrays;

import java.util.*;

/**
 * https://www.spoj.com/problems/BALLOT/
 * 
 * This problem is a variation of aggresive cows problem 
 * and it can also be solved using binary search technique.
 * 
 * The trick in such problems is applying binary search on array over which
 * we want to find an answer and then validate the answer.
 * 
 * @author Rahul
 */
public class BallotBoxDistribution {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int cities = sc.nextInt();
            int ballotBoxes = sc.nextInt();

            if (cities == -1 || ballotBoxes == -1) {
                break;
            }

            int[] population = new int[cities];

            for (int i = 0; i < cities; i++) {
                population[i] = sc.nextInt();
            }
            
            // Sort
            Arrays.sort(population);

            // We need to sort populations and apply binary sort technique over that
            // We can't apply binary sort technique over ballot boxes because their value will vary for each city
            // so we can't get one universal answer
            // Apply binary sort technique over population array and
            // check if a selected population can be served through available boxes
            int minPopulation = 1;
            int maxPopulation = population[cities - 1];
            int maxPeopleToVoteInOneBox = Integer.MAX_VALUE;

            while (minPopulation < maxPopulation) {
                int mid = (maxPopulation + minPopulation) / 2;

                if (checkIfCanBeServedThroughBallotBoxes(population, mid, ballotBoxes)) {
                    if (mid < maxPeopleToVoteInOneBox) {
                        maxPeopleToVoteInOneBox = mid;
                    }

                    // Try decreasing the max population served per ballot box by looking up in 
                    // smaller region
                    maxPopulation = mid;
                } else {
                    // Ballot boxes are not enough, Try increasing the max population served per ballot box by looking up in 
                    // higher region
                    minPopulation = mid + 1;
                }
            }

            System.out.println(maxPeopleToVoteInOneBox);
        }

    }

    private static boolean checkIfCanBeServedThroughBallotBoxes(int[] population, int maxPeopleToVoteInOneBox, int ballotBoxes) {
        int ballotBoxRequired = 0;

        for (int p : population) {
            if (p <= maxPeopleToVoteInOneBox) {
                ballotBoxRequired++;
            } else {
                ballotBoxRequired += (p / maxPeopleToVoteInOneBox);
                if (p % maxPeopleToVoteInOneBox > 0) {
                    ballotBoxRequired++;
                }
            }
        }

        return ballotBoxRequired <= ballotBoxes;
    }
}
