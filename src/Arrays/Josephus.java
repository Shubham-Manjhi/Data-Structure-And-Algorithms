package Arrays;

public class Josephus {

    //There are N people standing in a circle. On every pass, the kth person was killed. This cycle continues till only one person remains alive. Find out the alive person. (Josephus problem)

    // Function to find the only person left after one in every k is killed
    static int josephus(int n, int k) {
        if (n == 1) {
            return 1;
        } else {
            // The position returned by josephus(n - 1, k) is adjusted because the
            // recursive call josephus(n - 1, k) considers the original position
            // k%n + 1 as position 1
            return (josephus(n - 1, k) + k - 1) % n + 1;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println("The person left alive is " + josephus(n, k));
    }
}
