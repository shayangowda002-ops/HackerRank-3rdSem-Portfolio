import java.util.*;

/**
 * HackerRank: Balanced Brackets (Stacks)
 * Approach: push every opening bracket on a stack; each closing bracket
 * must match the bracket on top of the stack. The string is balanced
 * only if nothing mismatches and the stack is empty at the end.
 * Time: O(N)   Space: O(N)
 */
public class Solution {

    public static String isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                char open = stack.pop();
                if ((c == ')' && open != '(')
                        || (c == '}' && open != '{')
                        || (c == ']' && open != '[')) {
                    return "NO";
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    // Local test helper: prints PASS or FAIL
    static void runTest(String name, String input, String expected) {
        String result = isBalanced(input);
        if (result.equals(expected)) {
            System.out.println(name + ": PASS -> " + result);
        } else {
            System.out.println(name + ": FAIL (got " + result + ", expected " + expected + ")");
        }
    }

    public static void main(String[] args) {
        runTest("Test 1 (typical: {[()]})", "{[()]}", "YES");
        runTest("Test 2 (typical: {[(])})", "{[(])}", "NO");
        runTest("Test 3 (typical: nested {{[[(())]]}})", "{{[[(())]]}}", "YES");
        runTest("Test 4 (edge: only a closing bracket)", "}", "NO");
        runTest("Test 5 (edge: unclosed opening brackets)", "((", "NO");
    }
}