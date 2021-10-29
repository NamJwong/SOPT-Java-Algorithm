package week1;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Solution_1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n, m, count;

        for (int i = 0; i < t; i++) {
            LinkedList<int[]> queue = new LinkedList<>();
            count = 0;
            n = sc.nextInt();
            m = sc.nextInt();
            for (int j = 0; j < n; j++)
                queue.add(new int[]{j, sc.nextInt()});
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                boolean able = true;
                for (int[] q : queue)
                    if (q[1] > now[1]) able = false;
                if (able) {
                    count++;
                    if (now[0] == m) break;
                } else queue.add(now);
            }
            System.out.println(count);
        }
    }
}
