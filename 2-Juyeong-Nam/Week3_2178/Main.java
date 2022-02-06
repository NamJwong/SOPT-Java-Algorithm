import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] maze;
    static int x;
    static int y;
    static int distance;
    static int[][] checks;
    static Queue<int[]> queue;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        maze = new int[N][M];
        for(int i = 0; i < N; i++) {
            String temp = sc.next();
            for(int j = 0; j < M; j++) {
                maze[i][j] = temp.charAt(j) - '0';
            }
        }
        sc.close();
        x = 0;
        y = 0;
        checks = new int[N][M];
        queue = new LinkedList<>();
        distance = 1;
        queue.add(new int[] {0, 0, 1});
        checks[0][0] = 1;
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            if((temp[0] == N-1) && (temp[1] == M-1)) {
                System.out.println(temp[2]);
                break;
            }
            checkAdjacency(temp[0]+1, temp[1], temp[2]);
            checkAdjacency(temp[0]-1, temp[1], temp[2]);
            checkAdjacency(temp[0], temp[1]+1, temp[2]);
            checkAdjacency(temp[0], temp[1]-1, temp[2]);
        }
    }

    static void checkAdjacency(int x, int y, int distance) {
        try {
            if((maze[x][y] == 1) && (checks[x][y] == 0)) {
                queue.add(new int[] {x, y, distance+1});
                checks[x][y] = 1;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        }
    }
}
