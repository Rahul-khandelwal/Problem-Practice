/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.geeksforgeeks.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/find-highest-occurring-digit-prime-numbers-range/
 *
 * @author Rahul
 */
public class HighestOccuringDigitInPrimeNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt();

        for (int i = 0; i < tests; i++) {
            int min = sc.nextInt();
            int max = sc.nextInt();

            int[] digits = new int[10];

            // find all prime numbers till max using sieve-of-eratosthenes method
            // https://www.geeksforgeeks.org/sieve-of-eratosthenes/
            boolean isPrime[] = new boolean[max + 1];
            Arrays.fill(isPrime, true);

            for (int j = 2; j * j <= max; j++) {
                if (isPrime[j]) {
                    // consider j as prime and mark it's multipliers non-prime
                    for (int k = j * 2; k <= max; k += j) {
                        isPrime[k] = false;
                    }
                }
            }

            for (int j = min; j <= max; j++) {
                if (!isPrime[j]) {
                    continue;
                }

                char[] chars = String.valueOf(j).toCharArray();
                for (char c : chars) {
                    digits[Character.getNumericValue(c)]++;
                }
            }

            int count = 0;
            int num = -1;
            for (int c = 0; c < digits.length; c++) {
                if (digits[c] >= count) {
                    count = digits[c];
                    num = c;
                }
            }

            if (count == 0) {
                System.out.println(-1);
            } else {
                System.out.println(num);
            }
        }
    }
}
