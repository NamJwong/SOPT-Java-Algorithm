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
		boolean flag=false; //No�� ������ ���
		for(int i=0;i<n;i++) {
			int current_target=arr[i];
			//��ǥ ���ں��� ������� ���� ���� ������ pop�� �Ҽ��ۿ�����. pop�ߴµ� �ٸ� ���� ����
			if(current_target<=current) {
				sb.append("-\n");
				if(stack.size()==0||stack.pop()!=current_target) {
					flag=true;
					break;
				}
			}else {
				//��ǥ���ں��� ������� ���� ���� ũ�� ��ǥ���ڸ�ŭ push�� �� pop�ѹ�
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
//ó���� �޸��ʰ�.. String�� �ʰ��Ǿ ó������ ��Ʈ�� ���۸� ���.
//���� NO�� �ƴ� No�� �ع����� Ʋ�ȴ�..