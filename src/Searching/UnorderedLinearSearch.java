package Searching;

public class UnorderedLinearSearch {
    int linearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        UnorderedLinearSearch ls = new UnorderedLinearSearch();
        int[] arr = {10, 20, 80, 30, 60, 50, 110, 100, 130, 170};
        int x = 110;
        int result = ls.linearSearch(arr, x);
        if(result == -1)
            System.out.println("Element is not present in array");
        else
            System.out.println("Element is present at index " + result);
    }
}
