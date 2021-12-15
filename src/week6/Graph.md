


# Graph

### 목차

- BFS
- DFS
- BFS, DFS 비교
- Backtracking
- Backtracking, DFS 비교
- 정리

---

### BFS (Breadth First Search)

![](https://media.vlpt.us/images/lucky-korma/post/2112183b-bfcd-427e-8072-c9dc983180ba/R1280x0-2.gif)

- 그래프 탐색의 한 종류
- 너비 우선 탐색
- 루트, 임의의 노드엑서 시작하여 인접한 노드를 노드를 모두 확인 이후 다음 depth 탐색
- Queue를 사용하여 데이터를 탐색

```java
public class BFS {
    
    public ArrayList<String> bfs(HashMap<String, ArrayList<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList();
        ArrayList<String> needVisit = new ArrayList();
        needVisit.add(startNode);
        int count = 0;

        while (needVisit.size() > 0) {
            String node = (String) needVisit.remove(0);
            ++count;
            if (!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll((Collection) graph.get(node));
                System.out.println(visited);
            }
        }

        System.out.println("count : " + count);
        return visited;
    }
}
```

#### 최단경로

주로 두 노드 사이의 최단 경로를 찾고 싶은 경우 해당 방법이 DFS 보다 좋습니다. DFS로 탐색할 경우 모든 노드를 방문해야할 수도 있지만 BFS는 시작 노드의 가까운 노드부터 탐색하기 때문에 최단경로같은 경우
BFS가 더 좋습니다.

---

### DFS(Depth-First-Search)

![](https://media.vlpt.us/images/lucky-korma/post/30737a15-9adf-49a6-96a0-98c211cab1cc/R1280x0.gif)

- 그래프 탐색의 한 종류
- 깊이 우선 탐색
- 루트, 임의의 노드에서 시작하여 최대로 진입할 수 있는 깊이까지 탐색후 돌아와 다른 노드를 탐색하는 방식
- Stack을 사용하여 데이터를 탐색

```java
public class DFS {
    public DFS() {
    }

    public static ArrayList<String> dfs(HashMap<String, ArrayList<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList();
        ArrayList<String> needVisit = new ArrayList();
        needVisit.add(startNode);

        while (needVisit.size() > 0) {
            String node = (String) needVisit.remove(needVisit.size() - 1);
            if (!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll((Collection) graph.get(node));
                System.out.println(visited);
            }
        }

        return visited;
    }
}
```

#### 경로의 특징

예를 들어 a -> b 까지 가는 경로를 구하는데 제한 사항이 있어 특징을 저장해야 하는 경우라면 DFS를 사용해야합니다. BFS는 경로의 특징을 가지지 못함

---

### BFS, DFS 비교

- 시간 복잡도가 동일하며 단순 그래프의 정점을 방문하는 것이 문제라면 DFS, BFS 어느 것을 사용해도 상관없습니다.
- 경로에 특징을 저장하는 문제 -> DFS
- 검색 대상 그래프가 광범위하다면 -> DFS
- 최단 거리를 구해야 할 경우 -> BFS
- 검색 대상 그래프가 크지 않거나, 검색 시작으로 부터 원하는 대상이 근처에 있다면 -> BFS

---

### Backtracking

- 해를 찾는 도중 해가 아니어서 막히면, 되돌아가서 다시 해를 찾아가는 기법을 말합니다. 즉, 불필요한 반복을 중지하고 다른 경우를 탐색하는 것을 의미합니다.
- 최적화 문제와 결정 문제를 푸는 방법이 됩니다.

#### Backtracking, DFS 차이

DFS는 가능한 모든 경로를 탐색합니다 -> 불필요할 것 같은 경로를 사전에 차단하거나 하는 등의 행동이 없습니다.
즉, 경우의 수를 줄이지 못합니다.

Backtracking은 해당 경로를 방문했을때 이후에 방문할 경로가 해가 될 것 같지 않으면 더이상 가지 않고 되돌아 갑니다.
즉, 불필요한 경로를 조기 차단 할 수 있게 되어 경우의 수가 줄어들게 됩니다.

> DFS는 완전탐색을 목표로 하는 알고리즘이기 때문에 백트래킹 기법과 혼용하여 사용한다

#### NQueen

백트래킹 기법에 자주 등장하는 문제이며 DFS와 같이 사용하여 푸는 문제이다.

```java
public class N_queen {
    public static boolean isTrue(ArrayList<Integer> list, int col) {
        int row = list.size();
        for (int i = 0; i < row; i++) {
            if (list.get(i) == col || Math.abs(list.get(i) - col) == row - i) return false;
        }
        return true;
    }
    public static void dfs(int N, int row, ArrayList<Integer> list) {
        if (list.size() == N) {
            System.out.println(list);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (isTrue(list, i)) {
                list.add(i);
                dfs(N,row+1,list);
                list.remove(list.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        int n = 4;
        ArrayList<Integer> list = new ArrayList<>();
        dfs(n,0,list);
    }
}
```
---
### 정리

- BFS, DFS 시간 복잡도는 같다.
- 규모가 작거나, 최단거리를 구하는 경우 -> BFS
- 경로에 특징을 저장해야하거나, 규모가 큰 경우 -> DFS
- DFS, Backtracking은 비슷한 방법으로 탐색을 하지만 DFS는 모든 노드를 탐색하는 것이 목적이고,
  Backtracking은 불필요한 노드 탐색을 최대한 줄이는 것이 목적이다.
- 알고리즘 문제를 풀 때 DFS, Backtracking을 같이 쓰는게 대부분이다.


