package week7;

import java.util.*;

public class Solution_11403 {
    static int[][] graph;
    static int[][] result;
    static boolean[] visited;
    static int N;

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 0; i < N; i++) {
                if (!visited[i] && graph[node][i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                    result[start][i] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        graph = new int[N][N];
        result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            bfs(i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        scan.close();
    }
}
