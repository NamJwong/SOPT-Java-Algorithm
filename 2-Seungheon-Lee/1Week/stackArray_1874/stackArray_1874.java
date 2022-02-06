package stackArray_1874;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class stackArray_1874 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> st = new Stack<>();  // 숫자를 저장할 스택
        StringBuilder sb = new StringBuilder(); // 단순 String 연산보다 메모리 덜 사용

        int n = Integer.parseInt(br.readLine());

        int position = 0;   // 현재 숫자를 나타내줄 변수

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number > position) {
                for (int j = position; j < number; j++) {
                    st.push(j + 1);
                    sb.append('+').append('\n');
                }

                position = number;
            } else if (st.peek() != number) {
                System.out.println("NO");
                return;
            }

            st.pop();
            sb.append('-').append('\n');
        }

        System.out.println(sb);
    }
}
