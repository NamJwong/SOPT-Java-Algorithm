package week1;

import java.util.ArrayList;
import java.util.Stack;

public class Solution_1874 {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Character> list = new ArrayList<>();
        int[] arr = {4, 3, 6, 8, 7, 5, 2, 1};
        int count = 2;
        s.push(1);
        list.add('+');
        for (int i = 0; i < arr.length; ) {
            if (!s.isEmpty() && arr[i] == s.peek()) {
                s.pop();
                list.add('-');
                i++;
            } else if (arr[i] >= count) {
                s.push(count);
                list.add('+');
                count++;
            } else {
                break;
            }
        }
        if (s.isEmpty()) {
            for (Character item : list) {
                System.out.println(item);
            }
        } else {
            System.out.println("NO");
        }
    }
}
