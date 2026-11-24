import java.util.*;

/**
 * HackerRank: Time Conversion (Strings & Logic)
 * Approach: read the hour, then fix it for AM/PM. 12 AM becomes 00,
 * and any PM hour except 12 gets 12 added. The minutes and seconds
 * are copied unchanged, so the work does not grow with the input.
 * Time: O(1)   Space: O(1)
 */
public class Solution {

    public static String timeConversion(String s) {
        int hour = Integer.parseInt(s.substring(0, 2));
        String minutesAndSeconds = s.substring(2, 8);   // ":MM:SS"
        boolean isPM = s.charAt(8) == 'P';

        if (hour == 12) {
            hour = 0;        // 12 AM -> 00, and 12 PM -> 12 after the next line
        }
        if (isPM) {
            hour += 12;
        }
        return String.format("%02d", hour) + minutesAndSeconds;
    }

    // Local test helper: prints PASS or FAIL
    static void runTest(String name, String input, String expected) {
        String result = timeConversion(input);
        if (result.equals(expected)) {
            System.out.println(name + ": PASS -> " + result);
        } else {
            System.out.println(name + ": FAIL (got " + result + ", expected " + expected + ")");
        }
    }

    public static void main(String[] args) {
        runTest("Test 1 (typical: 07:05:45PM)", "07:05:45PM", "19:05:45");
        runTest("Test 2 (edge: midnight 12:00:00AM)", "12:00:00AM", "00:00:00");
        runTest("Test 3 (edge: noon 12:00:00PM)", "12:00:00PM", "12:00:00");
        runTest("Test 4 (typical: morning 09:30:15AM)", "09:30:15AM", "09:30:15");
    }
}