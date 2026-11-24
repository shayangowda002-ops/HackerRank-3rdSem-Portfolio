import java.util.*;

/**
 * HackerRank: Dynamic Array (Data Structures / Vectors)
 * Approach: keep n empty sequences. For each query, find the sequence
 * with idx = (x XOR lastAnswer) % n. Type 1 appends y to it. Type 2
 * reads element (y % size) from it, saves it as lastAnswer and records it.
 * Time: O(N + Q)   Space: O(N)   (N = sequences, Q = queries)
 */
public class Solution {

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<List<Integer>> seqList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            seqList.add(new ArrayList<>());
        }
        List<Integer> answers = new ArrayList<>();
        int lastAnswer = 0;

        for (List<Integer> q : queries) {
            int type = q.get(0);
            int x = q.get(1);
            int y = q.get(2);
            int idx = (x ^ lastAnswer) % n;
            List<Integer> seq = seqList.get(idx);
            if (type == 1) {
                seq.add(y);
            } else {
                lastAnswer = seq.get(y % seq.size());
                answers.add(lastAnswer);
            }
        }
        return answers;
    }

    // Local test helper: prints PASS or FAIL
    static void runTest(String name, int n, List<List<Integer>> queries, List<Integer> expected) {
        List<Integer> result = dynamicArray(n, queries);
        if (result.equals(expected)) {
            System.out.println(name + ": PASS -> " + result);
        } else {
            System.out.println(name + ": FAIL (got " + result + ", expected " + expected + ")");
        }
    }

    public static void main(String[] args) {
        runTest("Test 1 (typical: sample input)", 2,
                Arrays.asList(
                        Arrays.asList(1, 0, 5),
                        Arrays.asList(1, 1, 7),
                        Arrays.asList(1, 0, 3),
                        Arrays.asList(2, 1, 0),
                        Arrays.asList(2, 1, 1)),
                Arrays.asList(7, 3));

        runTest("Test 2 (edge: only one sequence)", 1,
                Arrays.asList(
                        Arrays.asList(1, 0, 10),
                        Arrays.asList(1, 5, 20),
                        Arrays.asList(2, 3, 0),
                        Arrays.asList(2, 3, 1)),
                Arrays.asList(10, 20));

        runTest("Test 3 (lastAnswer changes the sequence)", 3,
                Arrays.asList(
                        Arrays.asList(1, 0, 4),
                        Arrays.asList(1, 1, 9),
                        Arrays.asList(1, 2, 8),
                        Arrays.asList(2, 0, 0),
                        Arrays.asList(2, 1, 0)),
                Arrays.asList(4, 8));

        runTest("Test 4 (edge: no type 2 query)", 2,
                Arrays.asList(Arrays.asList(1, 0, 5)),
                new ArrayList<Integer>());
    }
}