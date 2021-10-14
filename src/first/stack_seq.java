package first;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
public class stack_seq {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb=new StringBuffer();
		int n=Integer.parseInt(br.readLine());
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack=new Stack<Integer>();
		int current=0;
		boolean flag=false; //No가 나오는 경우
		for(int i=0;i<n;i++) {
			int current_target=arr[i];
			//목표 숫자보다 현재까지 넣은 수가 작으면 pop을 할수밖에없다. pop했는데 다른 수면 실패
			if(current_target<=current) {
				sb.append("-\n");
				if(stack.size()==0||stack.pop()!=current_target) {
					flag=true;
					break;
				}
			}else {
				//목표숫자보다 현재까지 넣은 수가 크면 목표숫자만큼 push한 후 pop한번
				for(int j=current+1;j<=current_target;j++) {
					sb.append("+\n");
					stack.push(j);
				}
				current=current_target;
				sb.append("-\n");
				stack.pop();
			}
		}
		if(flag==true) {
			System.out.println("NO");
		}else {
			bw.write(sb.toString());
			bw.flush();
		}
	}
}
//처음엔 메모리초과.. String이 초과되어서 처음부터 스트링 버퍼를 썼다.
//그후 NO가 아닌 No로 해버려서 틀렸다..