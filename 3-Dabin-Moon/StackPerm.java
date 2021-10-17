import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackPerm {

	public static void main(String[] args) throws IOException {
		// Stack
		StringBuilder sb = new StringBuilder();
		int n;
		boolean success = true;
		int comp = 1;
		int num;
		Stack<Integer> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; ++i) {
			num = Integer.parseInt(br.readLine());
			while(comp <= num) {
				stack.add(comp++);
				sb.append('+').append('\n');
			}
			if(stack.size() > 0) {
				if(stack.pop() == num)
					sb.append('-').append('\n');
				else {
					success = false;
					break;
				}
			}
		}
		
		System.out.print(success? sb : "NO");
	}

}
