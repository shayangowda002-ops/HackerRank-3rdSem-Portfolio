import java.util.*;

/**
 * HackerRank: Sparse Arrays (Hash Maps / Strings)
 * Approach: count every input string once in a HashMap (string ->
 * frequency). Each query is then a single map lookup, so we never
 * rescan the whole list for every query.
 * Time: O(N + Q)   Space: O(N)   (N = strings, Q = queries)
 */
public class Solution {

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        Map<String, Integer> counts = new HashMap<>();
        for (String s : stringList) {
            counts.put(s, counts.getOrDefault(s, 0) + 1);
        }
        List<Integer> results = new ArrayList<>();
        for (String q : queries) {
            results.add(counts.getOrDefault(q, 0));
        }
        return results;
    }

    // Local test helper: prints PASS or FAIL
    static void runTest(String name, List<String> strings, List<String> queries, List<Integer> expected) {
        List<Integer> result = matchingStrings(strings, queries);
        if (result.equals(expected)) {
            System.out.println(name + ": PASS -> " + result);
        } else {
            System.out.println(name + ": FAIL (got " + result + ", expected " + expected + ")");
        }
    }

    public static void main(String[] args) {
        runTest("Test 1 (typical: sample 1)",
                Arrays.asList("aba", "baba", "aba", "xzxb"),
                Arrays.asList("aba", "xzxb", "ab"),
                Arrays.asList(2, 1, 0));

        runTest("Test 2 (typical: sample 2)",
                Arrays.asList("def", "de", "fgh"),
                Arrays.asList("de", "lmn", "fgh"),
                Arrays.asList(1, 0, 1));

        runTest("Test 3 (edge: query not in the list)",
                Arrays.asList("a", "b"),
                Arrays.asList("z"),
                Arrays.asList(0));

        runTest("Test 4 (edge: all strings the same)",
                Arrays.asList("x", "x", "x", "x"),
                Arrays.asList("x", "y"),
                Arrays.asList(4, 0));
    }
}