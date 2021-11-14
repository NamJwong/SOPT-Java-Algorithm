package week4;

import java.util.*;

public class Solution_2606 {
    //1번 컴퓨터 제외해야 해서 -1 시작
    static int count = -1;

    public static void dfs(int[][] graph, boolean[] visited, int node) {
        //방문한 노드는 실행할 필요가 없어 return
        if (visited[node]) return;
        visited[node] = true;
        ++count;
        //node와 연결된 모든 컴퓨터를 검사
        for (int i = 0; i < graph[node].length; i++) {
            //연결되어있는지 확인 + 방문했는지 확인
            if (graph[node][i] == 1 && !visited[i]) {
                // i를 시작 노드로 재귀함수
                dfs(graph, visited, i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int loop = scan.nextInt();

        int[][] graph = new int[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < loop; i++) {
            int key = scan.nextInt();
            int value = scan.nextInt();
            graph[key][value] = 1;
            graph[value][key] = 1;
        }
        dfs(graph, visited, 1);
        System.out.println(count);
    }
}
