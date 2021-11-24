package week6;

import java.io.*;

//1로 만들기
public class Solution_1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        //이미 1
        arr[1] = 0;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + 1;
            System.out.println("arr[" + i + "] = arr[" + (i - 1) + "] + 1");
            System.out.println("arr[" + i + "] = " + arr[i]);
            if (i % 3 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 3] + 1);
                System.out.println("arr[" + i + "] = arr[" + (i - 1) + "] + 1");
                System.out.println("arr[" + i + "] = " + arr[i]);
            }
            if (i % 2 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 2] + 1);
                System.out.println("arr[" + i + "] = arr[" + (i - 1) + "] + 1");
                System.out.println("arr[" + i + "] = " + arr[i]);
            }
        }

        bw.write(arr[n] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
