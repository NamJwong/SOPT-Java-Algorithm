package week6;


import java.util.*;

// LCS
public class Solution_9251 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str1 = scan.nextLine();
        String str2 = scan.nextLine();

        int[][] lcs = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                else
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
            }
        }
        System.out.println(lcs[str1.length()][str2.length()]);
    }
}
