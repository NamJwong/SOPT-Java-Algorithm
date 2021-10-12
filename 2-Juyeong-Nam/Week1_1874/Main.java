package Week1_1874;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        Stack<Integer> stack = new Stack<>();
        ArrayList<Character> list = new ArrayList<>();
        stack.push(1);
        list.add('+');
        int num = 2;
        for(int i = 0; i < n;) {
            if((!stack.empty()) && (arr[i] == stack.peek())) {
                list.add('-');
                stack.pop();
                i++;
            }else if(arr[i] >= num) {
                list.add('+');
                stack.push(num);
                num++;
            }else {
                break;
            }
        }

        if(stack.empty()) {
            for(int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }else {
            System.out.println("NO");
        }
    }
}
