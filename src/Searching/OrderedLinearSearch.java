package Searching;

public class OrderedLinearSearch {

    int orderedLinearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                return i;
            else if (arr[i] > x)
                return -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        OrderedLinearSearch ols = new OrderedLinearSearch();
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int x = 70;
        int result = ols.orderedLinearSearch(arr, x);
        if(result == -1)
            System.out.println("Element is not present in array");
        else
            System.out.println("Element is present at index " + result);
    }
}
