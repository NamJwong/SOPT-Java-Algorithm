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

	//우선순위큐 역순으로 하기위한 Comparator
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
				//먼저 처리해야할 우선순위를 pq에 담고, 프린터 정보는 큐에 담음
				q.add(new Printer(i,priority));
				pq.add(priority);
			}
			
			int count=1;
			boolean is_target=false;
			while(!pq.isEmpty()) {
				int current_priority=pq.poll();
				while(!q.isEmpty()) {
					Printer current_printer=q.poll();
					//큐에서 꺼낸게 처리해야할 우선순위가 같으면 꺼냄
					if(current_printer.priority==current_priority) {
						//꺼낸게 알고싶던 목표라면 표시
						if(current_printer.n==target) {
							is_target=true;
						}
						break;
					}else {
						//해당 우선순위가 아니라면 큐 맨뒤로 보냄
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

//번호와 우선순위를 가지는 프린터 클래스
class Printer {
	int n;
	int priority;
	
	public Printer(int n,int priority) {
		this.n=n;
		this.priority=priority;
	}

}
