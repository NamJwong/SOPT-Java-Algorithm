package week5;

import java.util.*;

//가장 많은 같은 날짜의 수 == 높이
// 이어지는 날짜의 수 == 길이

public class Solution_20207 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] day = new int[367];
        for (int i = 0; i < n; i++) {
            int s = scan.nextInt();
            int e = scan.nextInt();

            for (int j = s; j <= e; j++) day[j]++;
        }
        int w = 0;
        int h = 0;
        int width = 0;

        for (int i = 1; i <= 366; i++) {
            if (day[i] > 0) {
                h++;
                w = Math.max(w, day[i]);
            } else if (day[i] == 0) {
                width += w * h;
                w = 0;
                h = 0;
            }
        }
        scan.close();
        System.out.println(width);
    }
}
