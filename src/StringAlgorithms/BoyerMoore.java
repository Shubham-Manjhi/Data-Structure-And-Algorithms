package StringAlgorithms;

import java.util.Arrays;
import java.util.stream.Stream;

public class BoyerMoore {
    public final static int SIZE = 256; // size of the alphabet

    static void badCharHeuristic(char[] str, int size, int[] badchar) {
        int i;

        for (i = 0; i < SIZE; i++)
            badchar[i] = -1;

        for (i = 0; i < size; i++)
            badchar[(int) str[i]] = i;
    }

    static void search(char[] txt, char[] pat) {
        int m = pat.length;
        int n = txt.length;

        int[] badchar = new int[SIZE];

        badCharHeuristic(pat, m, badchar);

        int s = 0; // s is shift of the pattern with respect to text
        while (s <= (n - m)) {
            int j = m - 1;

            while (j >= 0 && pat[j] == txt[s + j])
                j--;

            if (j < 0) {
                System.out.println("Pattern occurs at shift " + s);

                s += (s + m < n) ? m - badchar[txt[s + m]] : 1;

            } else
                s += Math.max(1, j - badchar[txt[s + j]]);
        }
    }

    public static void main(String[] args) {
        char[] txt = "ABAAABCD".toCharArray();
        char[] pat = "ABC".toCharArray();
        search(txt, pat);

        txt = "AABAACAADAABAABA".toCharArray();
        pat = "AABA".toCharArray();
        search(txt, pat);

        Arrays.sort(txt);
    }
}
