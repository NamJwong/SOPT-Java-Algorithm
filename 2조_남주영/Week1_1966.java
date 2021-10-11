import java.util.*;

public class Week1_1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            Queue<Document> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int order = 0; order < N; order++) {
                int priority = sc.nextInt();
                q.add(new Document(order, priority));
                pq.add(priority);
            }
            ArrayList<Document> list = new ArrayList<>();
            while(!pq.isEmpty()) {
                if(q.peek().priority < pq.peek()) {
                    Document temp = q.poll();
                    q.add(temp);
                }else {
                    pq.remove();
                    list.add(q.poll());
                }
            }
            for(int j = 0; j < list.size(); j++) {
                if(list.get(j).order == M) {
                    System.out.println(j+1);
                    break;
                }
            }
        }
        sc.close();
    }

    static class Document {
        int order;
        int priority;

        public Document(int order, int priority) {
            this.order = order;
            this.priority = priority;
        }
    }
}
