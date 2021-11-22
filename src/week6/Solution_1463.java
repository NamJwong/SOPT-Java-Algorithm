package week6;

import java.io.*;

//1로 만들기
public class Solution_1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;  // 3번째 연산
            System.out.println("dp[" + i + "] = dp[" + (i - 1) + "] + 1");
            System.out.println("dp[" + i + "] = " + dp[i]);
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 2번째 연산
                System.out.println("dp[" + i + "] = dp[" + (i - 1) + "] + 1");
                System.out.println("dp[" + i + "] = " + dp[i]);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 1번째 연산
                System.out.println("dp[" + i + "] = dp[" + (i - 1) + "] + 1");
                System.out.println("dp[" + i + "] = " + dp[i]);
            }
        }

        bw.write(dp[N] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
