package virus_2606;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class virus_2606 {
    static int computer;
    static int network;
    static int[][] connection;
    static boolean[] check;
    static int virus = 0;

    // DFS 구현
    static int dfs(int here) {
        check[here] = true;

        for (int j = 1; j < computer+1; j++) {
            if (connection[here][j] == 1 && check[j] == false) {
                virus++;
                dfs(j);
            }
        }

        return virus;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 컴퓨터의 수
        computer = Integer.parseInt(br.readLine());
        // 네트워크 수
        network = Integer.parseInt(br.readLine());

        // 연결된 네트워크 체크
        connection = new int[computer+1][computer+1];
        for (int i = 0; i < network; i++) {
            String[] link = br.readLine().split(" ");
            int A = Integer.parseInt(link[0]);
            int B = Integer.parseInt(link[1]);
            connection[A][B] = 1;
            connection[B][A] = 1;
        }

        // 정점 방문 확인
        check = new boolean[computer+1];

        // 결과 출력
        System.out.println(dfs(1));
    }
}
