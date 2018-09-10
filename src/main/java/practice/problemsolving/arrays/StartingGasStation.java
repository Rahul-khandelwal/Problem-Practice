/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problemsolving.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/gas-station/
 *
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 *
 * Return the minimum starting gas station’s index if you can travel around the
 * circuit once, otherwise return -1.
 *
 * You can only travel in one direction. i to i+1, i+2, ... n-1, 0, 1, 2..
 * Completing the circuit means starting at i and ending up at i again.
 *
 * Example :
 *
 * Input : Gas : [1, 2] Cost : [2, 1]
 *
 * Output : 1
 *
 * If you start from index 0, you can fill in gas[0] = 1 amount of gas. Now your
 * tank has 1 unit of gas. But you need cost[0] = 2 gas to travel to station 1.
 * If you start from index 1, you can fill in gas[1] = 2 amount of gas. Now your
 * tank has 2 units of gas. You need cost[1] = 1 gas to get to station 0. So,
 * you travel to station 0 and still have 1 unit of gas left over. You fill in
 * gas[0] = 1 unit of additional gas, making your current gas = 2. It costs you
 * cost[0] = 2 to get to station 1, which you do and complete the circuit.
 *
 * NOTE That this question can also be solved using sliding window, try that
 * later.
 *
 * @author Rahul
 */
public class StartingGasStation {

    public static void main(String[] args) {
        List<Integer> gasAv = new ArrayList<>();
        List<Integer> gasRq = new ArrayList<>();
        int[] A = {959, 329, 987, 951, 942, 410, 282, 376, 581, 507, 546, 299, 564, 114, 474, 163, 953, 481, 337, 395, 679, 21, 335, 846, 878, 961, 663, 413, 610, 937, 32, 831, 239, 899, 659, 718, 738, 7, 209};
        int[] B = {862, 783, 134, 441, 177, 416, 329, 43, 997, 920, 289, 117, 573, 672, 574, 797, 512, 887, 571, 657, 420, 686, 411, 817, 185, 326, 891, 122, 496, 905, 910, 810, 226, 462, 759, 637, 517, 237, 884};

        for (int i : A) {
            gasAv.add(i);
        }

        for (int i : B) {
            gasRq.add(i);
        }

        System.out.println(canCompleteCircuit_2(gasAv, gasRq));
    }

    public static int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        int currStation = 0;
        int startingStation = -1;
        int totalGasInCar = 0;
        boolean roundComplete = false;

        while (true) {
            if (startingStation == currStation || (roundComplete && totalGasInCar <= 0)) {
                break;
            }

            totalGasInCar += A.get(currStation);
            int gasReqForNextStation = B.get(currStation);

            if (gasReqForNextStation <= totalGasInCar) {
                totalGasInCar -= gasReqForNextStation;
                if (startingStation == -1) {
                    startingStation = currStation;
                }
                currStation++;
            } else {
                totalGasInCar = 0;
                startingStation = -1;
                currStation++;
            }

            if (currStation == A.size()) {
                roundComplete = true;
                if (startingStation == -1) {
                    break;
                } else {
                    currStation = 0;
                }
            }
        }

        return startingStation;
    }

    /**
     * No idea if this one will work in every case 
     * 
     * @param gas
     * @param cost
     * @return 
     */
    public static int canCompleteCircuit_2(final List<Integer> gas, final List<Integer> cost) {
        int currentFuel = 0;
        int remaining = 0;
        int total = 0;
        int start = 0;
        for (int i = 0; i < gas.size(); i++) {
            remaining = gas.get(i) - cost.get(i);
            if (currentFuel >= 0) {
                currentFuel += remaining;
            } else {
                currentFuel = remaining;
                start = i;
            }
            total += remaining;
        }
        return total >= 0 ? start : -1;
    }
}
