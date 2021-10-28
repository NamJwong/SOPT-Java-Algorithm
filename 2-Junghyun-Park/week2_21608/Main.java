import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] classroom, nearEmptySeatCnt;
	static int N;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Student{
		int x;
		int y;
		int[] flist;
		
		public Student(int x, int y, int[] flist) {
			this.x = x;
			this.y = y;
			this.flist = flist;
		}
	}
	
	static Map<Integer, Student> list = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.valueOf(br.readLine());
		int N2 = N*N;
		int answer = 0;
		classroom = new int[N][N];
		fillNearEmptySeat();
		
		for(int i=0; i<N2; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.valueOf(st.nextToken());
			int s1 = Integer.valueOf(st.nextToken());
			int s2 = Integer.valueOf(st.nextToken());
			int s3 = Integer.valueOf(st.nextToken());
			int s4 = Integer.valueOf(st.nextToken());
			
			findSeat(num, new int[] {s1,s2,s3,s4});
		}
		
		for(int i=1; i<=N2; i++) {
			Student student = list.get(i);
			int cnt = 0;
			for(int friend : student.flist) {
				if(Math.abs(list.get(friend).x -student.x) + Math.abs(list.get(friend).y - student.y) == 1) {
					cnt++;
				}
			}
			
			if(cnt==1) answer+=1;
			else if(cnt==2) answer+=10;
			else if(cnt==3) answer+=100;
			else if(cnt==4) answer+=1000;
		}
		
		System.out.println(answer);
		
	}

	private static void findSeat(int num, int[] friends) {
		int[][] nearScore = new int[N][N]; //주변에 친한 친구가 많은 위치를 찾기 위한 배열
		for(int friend : friends) {
			if(list.containsKey(friend)) {
				Student student = list.get(friend);
				int x = student.x;
				int y = student.y;
				
				for(int i=0; i<4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					if(nx>=0 && nx <N && ny >=0 && ny < N && classroom[nx][ny] == 0) {
						nearScore[nx][ny]++;
					}
				}
			}
		}
		
		int emptyCntMax = -1;
		int nearScoreMax = -1;
		int choiceX = -1;
		int choiceY = -1;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(classroom[i][j] != 0) continue;
				if(nearScoreMax < nearScore[i][j]) {
					choiceX = i;
					choiceY = j;
					nearScoreMax = nearScore[i][j];
					emptyCntMax = nearEmptySeatCnt[i][j];
				} else if(nearScoreMax == nearScore[i][j] && emptyCntMax < nearEmptySeatCnt[i][j]) {
					emptyCntMax = nearEmptySeatCnt[i][j];
					choiceX = i;
					choiceY = j;
				}
			}
		}
		
		classroom[choiceX][choiceY] = num;
		list.put(num, new Student(choiceX,choiceY, friends));
		
		for(int i=0; i<4; i++) {
			int nx = choiceX+dx[i];
			int ny = choiceY+dy[i];
			if(nx>=0 && nx <N && ny >=0 && ny < N && classroom[nx][ny] == 0) {
				nearEmptySeatCnt[nx][ny]--;
			}
		}
	}
	
	private static void fillNearEmptySeat() {
		nearEmptySeatCnt = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int cnt = 4;
				if(i==0 || i==N-1) cnt--;
				if(j==0 || j==N-1) cnt--;
				nearEmptySeatCnt[i][j] = cnt;
			}
		}
	}

}

// https://velog.io/@mulgyeol/%EB%B0%B1%EC%A4%80-21608-%EC%83%81%EC%96%B4-%EC%B4%88%EB%93%B1%ED%95%99%EA%B5%90-Java