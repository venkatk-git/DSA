public class KMP {
    public static void main(String[] agrs) {

    } 

    static void kmp(String s) {
        int[] lps = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            int prefix_idx = lps[i - 1];

            while (prefix_idx > 0 && s.charAt(i) != s.charAt(prefix_idx))
                prefix_idx = lps[prefix_idx - 1];
            
            lps[i] = prefix_idx + (s.charAt(i) == s.charAt(prefix_idx) ? 1 : 0);
        }
    }
}
