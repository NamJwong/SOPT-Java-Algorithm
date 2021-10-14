package first;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class printer_queue {

	//�켱����ť �������� �ϱ����� Comparator
	static class comp implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2-o1;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb=new StringBuffer();
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int target=Integer.parseInt(st.nextToken());
			LinkedList<Printer> q=new LinkedList<Printer>();
			PriorityQueue<Integer> pq=new PriorityQueue<Integer>(new comp());
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				int priority=Integer.parseInt(st.nextToken());
				//���� ó���ؾ��� �켱������ pq�� ���, ������ ������ ť�� ����
				q.add(new Printer(i,priority));
				pq.add(priority);
			}
			
			int count=1;
			boolean is_target=false;
			while(!pq.isEmpty()) {
				int current_priority=pq.poll();
				while(!q.isEmpty()) {
					Printer current_printer=q.poll();
					//ť���� ������ ó���ؾ��� �켱������ ������ ����
					if(current_printer.priority==current_priority) {
						//������ �˰�ʹ� ��ǥ��� ǥ��
						if(current_printer.n==target) {
							is_target=true;
						}
						break;
					}else {
						//�ش� �켱������ �ƴ϶�� ť �ǵڷ� ����
						q.add(current_printer);
					}
				}
				if(is_target==true) {
					sb.append(count+"\n");
					break;
				}
				count++;
			}
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		
	}
}

//��ȣ�� �켱������ ������ ������ Ŭ����
class Printer {
	int n;
	int priority;
	
	public Printer(int n,int priority) {
		this.n=n;
		this.priority=priority;
	}

}
