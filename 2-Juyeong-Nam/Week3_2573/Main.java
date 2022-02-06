import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] arr;
    static int N;
    static int M;
    static int[][] checks;
    static int year;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();

        year = 0;
        while(true) {
            //checkIcebergNum는 문제 없다는 전제
            if(checkIcebergNum() > 1) {
                System.out.println(year);
                break;
            }
            year++;
            if(!melt()) {
                System.out.println(0);
                break;
            }
        }
    }

    static int checkIcebergNum() {
        checks = new int[N][M];
        int iceberg = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ((arr[i][j] != 0) && (checks[i][j] == 0)) {
                    iceberg++;
                    bfs(i, j);
                }
            }
        }
        return iceberg;
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        checks[x][y] = 1;
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            checkAdjacency(temp[0]+1, temp[1], queue);
            checkAdjacency(temp[0]-1, temp[1], queue);
            checkAdjacency(temp[0], temp[1]+1, queue);
            checkAdjacency(temp[0], temp[1]-1, queue);
        }
    }

    static void checkAdjacency(int x, int y, Queue<int[]> queue) {
        try {
            if((arr[x][y] != 0) && (checks[x][y] == 0)) {
                queue.add(new int[] {x, y});
                checks[x][y] = 1;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        }
    }

    static boolean melt() {
        boolean isMelted = false;
        int[][] newArr = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] != 0) {
                    isMelted = true;
                    int seaNum = 0;
                    seaNum += isSea(i+1, j);
                    seaNum += isSea(i-1, j);
                    seaNum += isSea(i, j+1);
                    seaNum += isSea(i, j-1);
                    if(arr[i][j] >= seaNum) {
                        newArr[i][j] = arr[i][j] - seaNum;
                    }
                }
            }
        }
        arr = newArr;
        return isMelted;
    }

    static int isSea(int x, int y) {
        try {
            if(arr[x][y] == 0) return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        return 0;
    }
}
