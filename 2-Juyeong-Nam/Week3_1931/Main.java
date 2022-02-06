import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Meeting> meetings = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            meetings.add(new Meeting(sc.nextInt(), sc.nextInt()));
        }
        sc.close();

        Collections.sort(meetings);
        int answer = 1;
        int finishIndex = 0;
        for(int i = 1; i < N; i++) {
            if(meetings.get(i).start >= meetings.get(finishIndex).finish) {
                answer++;
                finishIndex = i;
            }
        }

        System.out.println(answer);

    }
    static class Meeting implements Comparable<Meeting> {
        int start;
        int finish;
        public Meeting(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public int compareTo(Meeting meeting) {
            if(this.finish > meeting.finish) return 1;
            else if(this.finish == meeting.finish) {
                if(this.start > meeting.start) return 1;
                else if(this.start == meeting.start) return 0;
                else return -1;
            }
            else return -1;
        }
    }
}
