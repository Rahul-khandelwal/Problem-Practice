/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.geeksforgeeks.easy;

import java.util.*;

/**
 * https://practice.geeksforgeeks.org/problems/combine-the-strings/0
 * 
 * @author Rahul
 */
public class MaximumPossibleLengthOfCombinedString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            int strings = sc.nextInt();
            int rrLength = 0;
            int bbLength = 0;
            List<Integer> rbLengths = new ArrayList<>(1000);
            List<Integer> brLengths = new ArrayList<>(1000);

            boolean canUnite = false;

            for (int j = 0; j < strings; j++) {
                String str = sc.next();

                if (str.charAt(0) == 'R' && str.charAt(str.length() - 1) == 'R') {
                    if (!canUnite && rrLength > 0) {
                        canUnite = true;
                    }

                    rrLength += str.length();
                } else if (str.charAt(0) == 'B' && str.charAt(str.length() - 1) == 'B') {
                    if (!canUnite && bbLength > 0) {
                        canUnite = true;
                    }

                    bbLength += str.length();
                } else if (str.charAt(0) == 'R') {
                    rbLengths.add(str.length());
                } else {
                    brLengths.add(str.length());
                }
            }

            int possibleLength = 0;
            if (rbLengths.isEmpty() && brLengths.isEmpty()) {
                if (canUnite) {
                    possibleLength = rrLength > bbLength ? rrLength : bbLength;
                }
            } else if (!rbLengths.isEmpty() && !brLengths.isEmpty()) {
                Collections.sort(rbLengths, Collections.reverseOrder());
                Collections.sort(brLengths, Collections.reverseOrder());

                Iterator<Integer> rb = rbLengths.iterator();
                Iterator<Integer> br = brLengths.iterator();

                while (rb.hasNext() && br.hasNext()) {
                    possibleLength += rb.next();
                    possibleLength += br.next();
                }

                if (rb.hasNext()) {
                    possibleLength += rb.next();
                }

                if (br.hasNext()) {
                    possibleLength += br.next();
                }

                possibleLength += rrLength;
                possibleLength += bbLength;
            } else if (rbLengths.isEmpty()) {
                if (rrLength > 0 || bbLength > 0) {
                    Collections.sort(brLengths, Collections.reverseOrder());
                    possibleLength += (rrLength + bbLength + brLengths.get(0));
                }
            } else if (brLengths.isEmpty()) {
                if (rrLength > 0 || bbLength > 0) {
                    Collections.sort(rbLengths, Collections.reverseOrder());
                    possibleLength += (rrLength + bbLength + rbLengths.get(0));
                }
            }

            System.out.println(possibleLength);
        }
    }
}
