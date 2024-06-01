package StringAlgorithms;

public class KMPAlgorithm {
    // Function to implement the KMP algorithm
    void KMPSearch(String pat, String txt) {
        int M = pat.length(); // Length of the pattern
        int N = txt.length(); // Length of the text

        // lps will hold the longest prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0; // index for pat[]

        // Preprocess the pattern (calculate lps[] array)
        computeLPSArray(pat, M, lps);

        int i = 0; // index for txt[]
        // Traverse the text
        while (i < N) {
            // If current characters of pat and txt match, increment i and j
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            // If we found a match,
            if (j == M) {
                System.out.println("Pattern found at index " + (i - j));
                // Shift the pattern to continue the search
                j = lps[j - 1];
            }

            // If mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // If we do not match lps[0..lps[j-1]] characters, we do not backtrack in txt
                if (j != 0)
                    j = lps[j - 1];
                else // if j == 0, we move to next character of txt
                    i = i + 1;
            }
        }
    }

    // Function to calculate lps[]
    void computeLPSArray(String pat, int M, int lps[]) {
        int len = 0; // length of the previous longest prefix suffix
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    // Driver program to test above function
    public static void main(String args[]) {
        String txt = "THIS IS A TEST TEXT";
        String pat = "TEST";
        new KMPAlgorithm().KMPSearch(pat, txt);

        System.out.println();

        txt = "AABAACAADAABAABA";
        pat = "AABA";
        new KMPAlgorithm().KMPSearch(pat, txt);
    }
}
