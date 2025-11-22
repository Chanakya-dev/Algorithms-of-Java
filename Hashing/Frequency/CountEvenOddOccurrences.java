import java.util.*;

public class CountEvenOddOccurrences {
    public static void countEvenOdd(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Count frequency of each element
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int evenCount = 0;
        int oddCount = 0;

        // Count even and odd occurrences
        for (int count : freq.values()) {
            if (count % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Even occurrences: " + evenCount);
        System.out.println("Odd occurrences: " + oddCount);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 4};
        countEvenOdd(arr);
    }
}
