package practice.codechef;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.codechef.com/problems/COPS
 *
 * @author in-rahul.khandelwal
 */
public class CopsAndTheThiefDevu {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        int tests = sc.nextInt();

        for (int t = 0 ; t < tests ; t++) {
            int cops = sc.nextInt();
            int speedPerMinute = sc.nextInt();
            int timeInMinutes = sc.nextInt();
            boolean[] safeHouses = new boolean[100];
            Arrays.fill(safeHouses, true);

            for (int c = 0 ; c < cops ; c++) {
                int currHouse = sc.nextInt();
                int canCover = speedPerMinute * timeInMinutes;
                int canCoverLeftMost = Math.max(0, currHouse - (canCover + 1));
                int canCoverRightMost = Math.min(100, currHouse + canCover);

                Arrays.fill(safeHouses, canCoverLeftMost, canCoverRightMost, false);
            }

            int count = 0;
            for (boolean safe : safeHouses) {
                if (safe) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
