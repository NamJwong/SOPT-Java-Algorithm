package week7;

import java.util.*;

public class Solution_11403_Floyd {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        // i : 거쳐 가는 노드
        for (int i = 0; i < N; i++) {
            // j : 출발 노드
            for (int j = 0; j < N; j++) {
                // k : 도착 노드
                for (int k = 0; k < N; k++) {
                    if (arr[j][i] == 1 && arr[i][k] == 1) {
                        arr[j][k] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
