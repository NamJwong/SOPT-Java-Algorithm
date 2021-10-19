import java.util.*;

public class PrinterQ {

	public static void main(String[] args) {
		int test = 0;
		int n = 0;
		int m = 0;
		int pri = 0;
		int max;
		int max_n = 0;
		int count = 0;
		ArrayList<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		test = sc.nextInt();
		for(int i = 0; i < test; i++) {
			n = sc.nextInt();
			//int[] num = new int[n];
			count = 0;
			m = sc.nextInt();
			for(int j = 0; j < n; j++) {
				pri = sc.nextInt();
				list.add(pri);
			}
			while(true) {
				max = 0;
				for(int k = 0; k < list.size(); k++) {
					if(max == 0) {
						max = list.get(k);
						max_n = k;
					}
					else {
						if(list.get(k) > max) {
							max = list.get(k);
							list.add(list.get(max_n));
							list.remove(max_n);
							max_n = k;
							break;
						}
					}
				}
				if(max_n == 0) {
					if(m == 0) {
						count++;
						break;
					}
					else {
						count++;
						list.remove(max_n);
						m = m - 1;
					}
				}
				else {
					if(m == 0) {
						m = list.size() - 1;
					}
					else {
						m = m - 1;
					}
				}
			}
			System.out.println(count);
			list.clear();
		}
	}

}
