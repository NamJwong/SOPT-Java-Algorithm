import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] trees;
    static int N;
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        trees = new int[N];
        for(int i = 0; i < N; i++) {
            trees[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(trees);

        System.out.println(binarySearch());
    }

    static int binarySearch() {
        int start = 0;
        int end = trees[N-1];
        int middle = (start + end) / 2;
        int H = middle;
        long sum = 0;

        while(start <= end) {
            sum = 0;
            for(int i = 0; i < N; i ++) {
                if(trees[i] > middle) {
                    sum += trees[i] - middle;
                }
            }
            if(sum == M) return middle;
            if(sum > M) {
                start = middle + 1;
                H = middle;
                middle = (start + end) / 2;
            }else {
                end = middle - 1;
                middle = start + (end-start) / 2;
            }
        }
        return H;
    }
}
