package Arrays;

public class IntToRoman {
    public static String intToRoman(int num) {
        final String[] thousands = {"", "M", "MM", "MMM"};
        final String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        final String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        final String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[num / 1000] + hundreds[(num % 1000) / 100] + tens[(num % 100) / 10] + ones[num % 10];
    }

    public static String intToRomanLargeCase(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length && num >= 0; i++) {
            while (values[i] <= num) {
                num -= values[i];
                roman.append(symbols[i]);
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));    // Output: III
        System.out.println(intToRoman(58));   // Output: LVIII
        System.out.println(intToRoman(1994)); // Output: MCMXCIV

        System.out.println(intToRomanLargeCase(3));    // Output: III
        System.out.println(intToRomanLargeCase(58));   // Output: LVIII
        System.out.println(intToRomanLargeCase(1994)); // Output: MCMXCIV
    }
}