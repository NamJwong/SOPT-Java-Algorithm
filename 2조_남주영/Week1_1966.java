import java.util.*;

public class Week1_1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            Map<Integer,Integer> map = new HashMap<Integer, Integer>();
            for(int j = 0; j < N; j++) {
                map.put(j, sc.nextInt());
            }
            List<Integer> keySetList = new ArrayList<>(map.keySet());
            Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
            System.out.println(map.get(keySetList.indexOf(M)));
        }
        sc.close();
    }
}
