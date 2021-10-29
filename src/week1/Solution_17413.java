package week1;

import java.util.Arrays;

//17413_단어 뒤집기2
public class Solution_17413 {
    public static String solution(String str) {
        String answer = "";
        String temp = "";
        boolean tagIn = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '<') {
                if (temp.length() > 0) {
                    answer += temp;
                    temp = "";
                }
                tagIn = true;
            }
            if (tagIn) {
                answer += str.charAt(i);
            } else {
                if (str.charAt(i) == ' ' || i == str.length() - 1) {
                    StringBuilder sb = new StringBuilder(temp).reverse().append(" ");
                    answer += sb.toString();
                    temp = "";

                } else {
                    temp += str.charAt(i);
                }
            }
            if (str.charAt(i) == '>')
                tagIn = false;
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "baekjoon online judge";
        String s2 = "<open>tag<close>";
        String s3 = "<   space   >space space space<    spa   c e>";
        String s4 = "<problem>31471<is hardest>melborp reve<end>";
        System.out.println(solution(s));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));
    }
}
