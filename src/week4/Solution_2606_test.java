package week4;

import java.util.*;

public class Solution_2606_test {

    public static int bfs(HashMap<Integer, List<Integer>> graph, int startNode) {
        HashSet<Integer> visited = new HashSet<>();
        List<Integer> needVisit = new ArrayList<>();
        needVisit.add(startNode);
        while (needVisit.size() > 0) {
            int node = needVisit.remove(0);
            if (!visited.contains(node)) {
                visited.add(node);
                try {
                    needVisit.addAll(graph.get(node));
                } catch (Exception e) {
                    needVisit.add(node);
                }
            }
        }
        return visited.size() - 1;
    }

    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, new ArrayList<>(Arrays.asList(2, 5)));
        graph.put(2, new ArrayList<>(Arrays.asList(3)));
        graph.put(4, new ArrayList<>(Arrays.asList(7)));
        graph.put(5, new ArrayList<>(Arrays.asList(2, 6)));

        int result = bfs(graph, 1);
        System.out.println(result);
    }
}
