package practice.problemsolving.arrays;

import java.util.Arrays;

/**
 * Sort an array of 0s, 1s and 2s
 * https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 *
 * @author in-rahul.khandelwal
 */
public class SortArrayOfOnesTwosThrees {

    public static void main(String[] args) {
        var vals = new int[]{1, 0, 2, 2, 0, 1, 2, 2, 1, 1, 0, 0};
        System.out.println(Arrays.toString(sortUsingCount(vals)));
        
        sortUsingPartioning(vals);
        System.out.println(Arrays.toString(vals));
    }

    private static int[] sortUsingCount(int[] input) {
        if (input.length == 0) {
            return input;
        }

        var ones = 0;
        var twos = 0;
        var zeroes = 0;

        for (var i : input) {
            switch (i) {
                case 0:
                    zeroes++;
                    break;
                case 1:
                    ones++;
                    break;
                default:
                    twos++;
                    break;
            }
        }

        var output = new int[zeroes + ones + twos];
        Arrays.fill(output, 0, zeroes, 0);
        Arrays.fill(output, zeroes, zeroes + ones, 1);
        Arrays.fill(output, zeroes + ones, output.length, 2);

        return output;
    }

    /**
     * This problem is variation of famous Dutch national flag problem.
     * http://users.monash.edu/~lloyd/tildeAlgDS/Sort/Flag/
     *
     * Algorithm:
     * <p>
     * 1. Keep three indices low = 1, mid = 1 and high = N and there are four ranges, 1 to low (the range containing 0), low to mid (the range containing 1), mid to high (the range containing unknown elements) and high to N (the range containing 2).
     * 2. Traverse the array from start to end and mid is less than high. (Loop counter is i)
     * 3. If the element is 0 then swap the element with the element at index low and update low = low + 1 and mid = mid + 1
     * 4. If the element is 1 then update mid = mid + 1
     * 5. If the element is 2 then swap the element with the element at index high and update high = high – 1 and update i = i – 1. As the swapped element is not processed
     * </p
     * @param input
     */
    private static void sortUsingPartioning(int[] input) {
        var low = 0;
        var mid = 0;
        var high = input.length - 1;
        var temp = 0;

        while (mid <= high) {
            switch (input[mid]) {
                case 0: {
                    temp = input[low];
                    input[low] = input[mid];
                    input[mid] = temp;
                    low++;
                    mid++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    temp = input[mid];
                    input[mid] = input[high];
                    input[high] = temp;
                    high--;
                    break;
                }
            }
        }
    }
}
