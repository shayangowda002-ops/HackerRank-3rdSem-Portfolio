import java.util.*;

/**
 * HackerRank: Compare the Triplets (Basic Implementation)
 * Approach: compare Alice's and Bob's ratings at the same position.
 * Whoever has the higher rating gets 1 point; equal ratings give no
 * points. There are always exactly 3 ratings, so the loop is constant.
 * Time: O(1)   Space: O(1)
 */
public class Solution {

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int alice = 0;
        int bob = 0;
        for (int i = 0; i < 3; i++) {
            if (a.get(i) > b.get(i)) {
                alice++;
            } else if (a.get(i) < b.get(i)) {
                bob++;
            }
        }
        return Arrays.asList(alice, bob);
    }

    // Local test helper: prints PASS or FAIL
    static void runTest(String name, List<Integer> a, List<Integer> b, List<Integer> expected) {
        List<Integer> result = compareTriplets(a, b);
        if (result.equals(expected)) {
            System.out.println(name + ": PASS -> " + result);
        } else {
            System.out.println(name + ": FAIL (got " + result + ", expected " + expected + ")");
        }
    }

    public static void main(String[] args) {
        runTest("Test 1 (typical: sample 5 6 7 vs 3 6 10)",
                Arrays.asList(5, 6, 7), Arrays.asList(3, 6, 10),
                Arrays.asList(1, 1));

        runTest("Test 2 (typical: sample 17 28 30 vs 99 16 8)",
                Arrays.asList(17, 28, 30), Arrays.asList(99, 16, 8),
                Arrays.asList(2, 1));

        runTest("Test 3 (edge: all equal, no points)",
                Arrays.asList(4, 4, 4), Arrays.asList(4, 4, 4),
                Arrays.asList(0, 0));

        runTest("Test 4 (edge: Alice wins every round)",
                Arrays.asList(100, 100, 100), Arrays.asList(1, 1, 1),
                Arrays.asList(3, 0));
    }
}