package Searching;

public class BinarySearch {
    int recursiveBinarySearch(int[] arr, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return recursiveBinarySearch(arr, l, mid - 1, x);
            return recursiveBinarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }

    int iterativeBinarySearch(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == x)
                return m;
            if (arr[m] < x)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = new int[]{2, 3, 4, 10, 40};
        int x = 10;
        int resultIterative = binarySearch.iterativeBinarySearch(arr, x);
        int resultRecursive = binarySearch.recursiveBinarySearch(arr, 0, arr.length - 1, x);
        System.out.println("Iterative Binary Search result: " + resultIterative);
        System.out.println("Recursive Binary Search result: " + resultRecursive);
    }
}
