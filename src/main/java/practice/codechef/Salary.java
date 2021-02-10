package practice.codechef;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.codechef.com/problems/SALARY
 *
 * @author in-rahul.khandelwal
 */
public class Salary {

    public static void main(String[] args) {
        var in = new Scanner(System.in);

        var tests = in.nextInt();

        for (int i = 0; i < tests; i++) {
            var workers = in.nextInt();
            var wages = new int[workers];

            for (int w = 0; w < workers; w++) {
                wages[w] = in.nextInt();
            }

            System.out.println(formula(wages));
        }
    }

    /**
     * https://discuss.codechef.com/t/explaniation-for-the-salary-editorial/13982
     * @param wages
     * @return
     */
    private static int formula(int[] wages) {
        int min = Arrays.stream(wages).min().getAsInt();
        int sum = Arrays.stream(wages).sum();

        return sum - (min * wages.length);
    }

    private static int bruteForce(int[] wages) {
        int rounds = 0;

        while (!allEqualWages(wages)) {
            rounds++;
            var indexOfLargest = indexOfLargest(wages);

            for (int c = 0; c < wages.length; c++) {
                if (c != indexOfLargest) {
                    wages[c]++;
                }
            }
        }

        return rounds;
    }

    private static boolean allEqualWages(int[] arr) {
        return Arrays.stream(arr).distinct().count() == 1;
    }

    private static int indexOfLargest(int[] arr) {
        int indexOfLargest = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[indexOfLargest]) {
                indexOfLargest = i;
            }
        }

        return indexOfLargest;
    }

}
