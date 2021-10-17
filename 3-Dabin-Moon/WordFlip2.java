import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class WordFlip2 {

	public static void main(String[] args) throws IOException {
		// ¹®ÀÚ¿­
		boolean notFlip = false;
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		char a;
		int limit;
		String s;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();
		
		for(int i = 0; i < s.length(); ++i) {
			a = s.charAt(i);
			if(notFlip) {
				if(a == '>') {
					notFlip = false;
					sb.append(a);
				}
				else
					sb.append(a);
			}
			else {
				if(a == '<') {
					limit = stack.size();
					for(int j = 0; j < limit; ++j)
						sb.append(stack.pop());
					notFlip = true;
					sb.append(a);
				}
				else if(a == ' ') {
					limit = stack.size();
					for(int j = 0; j < limit; ++j)
						sb.append(stack.pop());
					sb.append(a);
				}
				else
					stack.push(a);
			}
		}
		
		limit = stack.size();
		for(int j = 0; j < limit; ++j)
			sb.append(stack.pop());
		
		System.out.println(sb);
	}

}
