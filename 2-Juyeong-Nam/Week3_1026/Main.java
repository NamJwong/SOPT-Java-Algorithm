import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Integer[] B = new Integer[N]; 
        for(int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());
        int answer = 0;
        for(int i = 0; i < N; i++) {
            answer += A[i]*B[i];
        }
        System.out.println(answer);
    }
}
