package dfsbfs_1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class dfsbfs_1260 {
    static int vertax;
    static int lineNumber;
    static int start;
    static int lines[][];
    static boolean[] check;

    // dfs 구현
    static void dfs(int here) {
        // 출발정점은 출력하고 시작
        System.out.print(here + " ");

        check[here] = true;
        for (int j = 1; j < vertax+1; j++) {
            if (lines[here][j] == 1 && check[j] == false) {
                dfs(j);
            }
        }
    }

    // bfs 구현
    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        // 시작 정점은 바로 queue에 포함
        queue.offer(start);
        check[start] = true;
        System.out.print(start + " ");

        while(!queue.isEmpty()) {
            int temp = queue.poll();

            for (int k = 1; k < vertax+1; k++) {
                if(lines[temp][k] == 1 && check[k] == false) {
                    queue.offer(k);
                    check[k] = true;
                    System.out.print(k + " ");
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 개수
        vertax = Integer.parseInt(st.nextToken());

        // 간선의 개수(간선은 양방향이다)
        lineNumber = Integer.parseInt(st.nextToken());

        // 시작할 정점의 번호
        start = Integer.parseInt(st.nextToken());

        // 정점에 존재하는 간선 표시
        lines = new int[vertax+1][vertax+1];
        for (int i = 0; i < lineNumber; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            lines[A][B] = 1;
            lines[B][A] = 1;
        }

        // 정점 방문 확인
        check = new boolean[vertax+1];

        // 결과 출력
        dfs(start);
        System.out.println();

        // 정점 방문 확인 초기화
        check = new boolean[vertax+1];
        bfs();
    }
}
