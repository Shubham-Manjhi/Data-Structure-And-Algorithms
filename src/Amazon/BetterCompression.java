package Amazon;

import java.util.Map;
import java.util.TreeMap;

public class BetterCompression {

    public static String betterCompression(String s) {

        StringBuilder result = new StringBuilder();
        Map<Character, Integer> frequencyMap = new TreeMap<>();

        for (int i = 0; i < s.length(); ) {
            char alphabet = s.charAt(i++);
            StringBuilder countStr = new StringBuilder();

            while (i<s.length() && Character.isDigit(s.charAt(i))) {
                countStr.append(s.charAt(i));
                i++;
            }
            frequencyMap.put(alphabet, frequencyMap.getOrDefault(alphabet, 0) + Integer.parseInt(countStr.toString()));
        }
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            result.append(entry.getKey());
            result.append(entry.getValue());
        }
        return result.toString();
    }

    public static String betterCompressionBetterOptimized(String s) {

        StringBuilder result = new StringBuilder();
        Map<Character, Integer> frequencyMap = new TreeMap<>();

        for (int i = 0; i < s.length(); ) {
            char alphabet = s.charAt(i++);
            StringBuilder countStr = new StringBuilder();

            while (i<s.length() && Character.isDigit(s.charAt(i))) {
                countStr.append(s.charAt(i));
                i++;
            }
            frequencyMap.put(alphabet, frequencyMap.getOrDefault(alphabet, 0) + Integer.parseInt(countStr.toString()));
        }
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            result.append(entry.getKey());
            result.append(entry.getValue());
        }
        return result.toString();
    }

    public static void main(String[] args) {

        String input = "a1b4c5a3b5";
        System.out.println(betterCompression(input));
    }

}
