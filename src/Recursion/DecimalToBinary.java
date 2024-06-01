package Recursion;

public class DecimalToBinary {

    // Brute Force
    public static String decimalToBinaryBruteForce(int decimal) {
        if (decimal == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            binary.insert(0, decimal % 2);
            decimal = decimal / 2;
        }

        return binary.toString();
    }

    // Recursive
    public static String decimalToBinary(int decimal) {
        if (decimal == 0) {
            return "";
        } else {
            return decimalToBinary(decimal / 2) + (decimal % 2);
        }
    }


    public static void main(String[] args) {
        int decimal = 10;
        String binary = decimalToBinaryBruteForce(decimal);
        System.out.println("The binary representation of " + decimal + " is " + binary);

        decimal = 10;
        binary = Integer.toBinaryString(decimal);
        System.out.println("The binary representation of " + decimal + " is " + binary);
    }
}
