package week4;

import java.util.*;

public class Solution_1260 {
    public static void bfs(int[][] graph, boolean[] visited, int node) {
        Queue<Integer> queue = new LinkedList<>();
        int n = graph.length - 1;
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node + " ");
            for (int i = 1; i <= n; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void dfs(int[][] graph, boolean[] visited, int node) {
        int n = graph.length - 1;
        visited[node] = true;
        System.out.print(node + " ");
        for (int i = 1; i <= n; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(graph, visited, i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();
        int v = scan.nextInt();

        int[][] graph = new int[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int key = scan.nextInt();
            int value = scan.nextInt();
            graph[key][value] = 1;
            graph[value][key] = 1;
        }
        dfs(graph, visited, v);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(graph, visited, v);
        scan.close();
    }
}
