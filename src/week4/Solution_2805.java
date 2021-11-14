package week4;

import java.io.*;
import java.util.*;


//그냥 무지성 반복문 대입 -> 시간초과
//BufferReader 써야 하나? -> 안써도 되네
// 이분 탐색을 하는 문제 같다.
//
public class Solution_2805 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] woods = new int[n];
        for (int i = 0; i < n; i++) {
            woods[i] = scan.nextInt();
        }
        Arrays.sort(woods);
        int left = 0;
        int right = woods[n - 1];

        while (left <= right) {
            long height = 0;
            int mid = (left + right) / 2;
            for (int i = 0; i < n; i++) {
                if (woods[i] >= mid) {
                    height += (woods[i] - mid);
                }
            }
            if (height >= m)
                left = mid + 1;
            else
                right = mid - 1;
        }
        scan.close();
        System.out.println(right);
    }
}
