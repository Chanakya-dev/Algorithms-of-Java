import java.util.*;

public class FirstNonRepeatingChar {
    public static char firstNonRepeatingChar(String s) {
        Map<Character, Integer> freq = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        String str = "leetcode";
        char result = firstNonRepeatingChar(str);
        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}
