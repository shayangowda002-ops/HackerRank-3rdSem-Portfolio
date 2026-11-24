import java.util.*;

/**
 * HackerRank: Diagonal Difference (2D Arrays)
 * Approach: walk down the matrix once. Add arr[i][i] to the primary
 * diagonal sum and arr[i][n-1-i] to the secondary diagonal sum, then
 * return the absolute difference of the two sums.
 * Time: O(N)   Space: O(1)   (N = number of rows)
 */
public class Solution {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int n = arr.size();
        int primary = 0;     // top-left to bottom-right
        int secondary = 0;   // top-right to bottom-left
        for (int i = 0; i < n; i++) {
            primary += arr.get(i).get(i);
            secondary += arr.get(i).get(n - 1 - i);
        }
        return Math.abs(primary - secondary);
    }

    // Local test helper: prints PASS or FAIL
    static void runTest(String name, List<List<Integer>> arr, int expected) {
        int result = diagonalDifference(arr);
        if (result == expected) {
            System.out.println(name + ": PASS -> " + result);
        } else {
            System.out.println(name + ": FAIL (got " + result + ", expected " + expected + ")");
        }
    }

    public static void main(String[] args) {
        runTest("Test 1 (typical: sample 3x3)",
                Arrays.asList(
                        Arrays.asList(11, 2, 4),
                        Arrays.asList(4, 5, 6),
                        Arrays.asList(10, 8, -12)),
                15);

        runTest("Test 2 (edge: 1x1 matrix)",
                Arrays.asList(Arrays.asList(5)),
                0);

        runTest("Test 3 (edge: secondary diagonal larger)",
                Arrays.asList(
                        Arrays.asList(1, 10),
                        Arrays.asList(10, 1)),
                18);
    }
}