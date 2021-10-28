import  java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] schedule = new int[N][2];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(schedule, new Comparator<int[]>() {
            @Override
            public int compare(int[] start, int[] end) {

                //시작시간과 끝시간이 같은 경우 시작시간을 서로 비교
                if(start[1] == end[1]) {
                    return Integer.compare(start[0], end[0]);
                }

                return Integer.compare(start[1],end[1]);
            }
        });

        int count = 0;
        int end = -1;

        for(int i=0; i<N; i++) {
            if(end <= schedule[i][0]) {
                end = schedule[i][1];
                count++;
            }
        }

        System.out.println(count);

    }

}