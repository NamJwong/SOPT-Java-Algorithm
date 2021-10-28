import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args)  {
        
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        int[] A = new int[n];
        int[] B = new int[n];
 
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
 
        }

        //정렬
        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;

        //A의 첫값과 B의 마지막값 곱해주는 방식
        for (int i = 0; i < n; i++) {
            sum += A[i] * B[n - 1 - i];
        }
        System.out.println(sum);
 
        sc.close();
    }
}

/** 
    배열 A B의 원소값을 곱해서 최소 값을 만들 수 있도록하는 A의 정렬 구하기
    - A의 가장 작은 값과 B의 가장 큰 값을 더해야함.
    Arrays.sort를 통해 투 배열을 정렬하고 A의 첫값과 B의 마지막값을 더하는 방식 사용
**/