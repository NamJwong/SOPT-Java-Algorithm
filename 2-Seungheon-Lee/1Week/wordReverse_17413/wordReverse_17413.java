package wordReverse_17413;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class wordReverse_17413 {
    static void popStack(Stack st) {    // 스택에 있는 내용 출력
        while (!st.isEmpty()) {
            System.out.print(st.pop());
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> st = new Stack<>();
        boolean tagCheck = false;   // 문자의 태그포함 체크

        String sentence = br.readLine();

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == '<') {    // 태그가 시작되면
                tagCheck = true;
                popStack(st);   // 스택에 쌓인 문자 출력
            } else if (sentence.charAt(i) == '>') { // 태그가 끝나면
                tagCheck = false;
                System.out.print(sentence.charAt(i));
                continue;
            }

            if (tagCheck) { // 태그 문자는 그대로 출력
                System.out.print(sentence.charAt(i));
            } else {    // 일반문자는 스택에 push
                if (sentence.charAt(i) == ' ') {
                    popStack(st);
                    System.out.print(" ");
                    continue;
                }
                st.push(sentence.charAt(i));
            }
        }
        popStack(st);
    }
}
