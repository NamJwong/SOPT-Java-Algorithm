import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final int INF = (int) 1e9; 
    public static int n, m;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static boolean[] visited;
    public static int[] shortestTable;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<Node>());
        }
        for(int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int distance = sc.nextInt();
            // from 정점에서 to 정점으로 가는 거리가 distance
            graph.get(from).add(new Node(to, distance));
            graph.get(to).add(new Node(from, distance));
        }
        int p = sc.nextInt();
        int q = sc.nextInt();
        int[] house = new int[p];
        int[] store = new int[q];
        for(int i = 0; i < p; i++) {
            house[i] = sc.nextInt();
        }
        for(int i = 0; i < q; i++) {
            store[i] = sc.nextInt();
        }
        sc.close();
        int min = INF;
        int answer = 0;
        for(int i = 0; i < p; i++) {
            init();
            dijkstra(house[i]);
            for(int j = 0; j < q; j++) {
                if(shortestTable[store[j]] < min) {
                    min = shortestTable[store[j]];
                    answer = house[i];
                }
            }
        }
        System.out.println(answer);
    }

    static class Node {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    public static void init() {
        visited = new boolean[5001];
        shortestTable = new int[5001];
        Arrays.fill(shortestTable, INF);
    }

    public static int getSmallestNode() {
        int min_value = INF;
        int index = 0;
        for(int i = 1; i <= n; i++) {
            if(shortestTable[i] < min_value && !visited[i]) {
                min_value = shortestTable[i];
                index = i;
            }
        }
        return index;
    }

    public static void dijkstra(int start) {
        shortestTable[start] = 0;
        visited[start] = true;
        for(int i = 0; i < graph.get(start).size(); i++) {
            shortestTable[graph.get(start).get(i).index] = graph.get(start).get(i).distance;
        }
        for(int i = 0; i < n - 1; i++) {
            int now = getSmallestNode();
            visited[now] = true;
            for(int j = 0; j < graph.get(now).size(); j++) {
                int cost = shortestTable[now] + graph.get(now).get(j).distance;
                if(cost < shortestTable[graph.get(now).get(j).index]) {
                    shortestTable[graph.get(now).get(j).index] = cost;
                }
            }
        }
    }
}
