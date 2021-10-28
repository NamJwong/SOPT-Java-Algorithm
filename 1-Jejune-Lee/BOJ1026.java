import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ1026 {
    public static void main(String[] args){
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
        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i] * B[n - 1 - i];
        }
        System.out.println(sum);

        /*
        리스트 사용한 풀이법.
        Scanner scanner = new Scanner(System.in);

        int arrSize = scanner.nextInt();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < arrSize; i++) {
            a.add(scanner.nextInt());
        }

        for (int i = 0; i < arrSize; i++) {
            b.add(scanner.nextInt());
        }

        a.sort(Comparator.naturalOrder());
        b.sort(Comparator.reverseOrder());

        for (int i = 0; i < arrSize; i++) {
            int mult = a.get(i) * b.get(i);
            sum += mult;
        }

        System.out.println(sum);

*/
    }
}