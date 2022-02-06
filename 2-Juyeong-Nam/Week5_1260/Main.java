import java.util.*;

public class Main {
    static TreeMap<Integer, TreeSet<Integer>> graph;
    static int N;
    static int V;
    static int[] checks;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        V = sc.nextInt();
        graph = new TreeMap<>();
        for(int i = 0; i < M; i++) {
            int vertex1 = sc.nextInt();
            int vertex2 = sc.nextInt();
            if(!graph.containsKey(vertex1)) {
                graph.put(vertex1, new TreeSet<>());
            }
            graph.get(vertex1).add(vertex2);
            if(!graph.containsKey(vertex2)) {
                graph.put(vertex2, new TreeSet<>());
            }
            graph.get(vertex2).add(vertex1);
        }
        sc.close();
      
        dfs();
        System.out.println();
        bfs();
    }

    static void dfs() {
        checks = new int[N+1];
        if(!graph.containsKey(V)) {
            System.out.print(V + " ");
            return;
        }
        dfsVisit(V);
        Iterator<Integer> vertexes = graph.keySet().iterator();
        while (vertexes.hasNext()) {
            int vertex = vertexes.next();
            if(checks[vertex] == 0) {
                dfsVisit(vertex);
            }
        }
    }

    static void dfsVisit(int vertex) {
        checks[vertex] = 1;
        System.out.print(vertex + " ");
        for(int adj : graph.get(vertex)) {
            if(checks[adj] == 0) {
                dfsVisit(adj);
            }
        }
    }

    static void bfs() {
        checks = new int[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        checks[V] = 1;
        System.out.print(V + " ");
        if(!graph.containsKey(V)) return;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (int adj : graph.get(vertex)) {
                if(checks[adj] == 0) {
                    checks[adj] = 1;
                    System.out.print(adj + " ");
                    queue.add(adj);
                }
            }
        }
    }
}
