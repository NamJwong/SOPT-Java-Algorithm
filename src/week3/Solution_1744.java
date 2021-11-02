package week3;

import java.util.*;

public class Solution_1744 {

    //주어진 배열을 정렬
    //음수는 작은거 끼리 곱한다
    //1를 제외한 양수는 곱하며 큰거 끼리 곱한다.

    public static int solution(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int start = 0;
        int end = n - 1;
        int answer = 0;
        for (; start < end; start += 2) {
            if (arr[start] < 1 && arr[start + 1] < 1) {
                answer += arr[start] * arr[start + 1];
            } else {
                //더이상 음수가 없다.
                break;
            }
        }
        for (; end > 0; end -= 2) {
            if (arr[end] > 1 && arr[end - 1] > 1) {
                answer += arr[end] * arr[end-1];
            }else{
                //더이상 1 보다 큰수가 없다.
                break;
            }
        }
        for (; end >= start; end--) {
            answer += arr[end];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr1 = {-1, 2, 1, 3};
        int[] arr2 = {0, 1, 2, 3, 4, 5};
        int[] arr3 = {-1};
        int[] arr4 = {-1, 0, 1};
        int[] arr5 = {1, 1};
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);
        Arrays.sort(arr4);
        Arrays.sort(arr5);
        System.out.println("arr1 : " + solution(arr1));
        System.out.println("arr2 : " + solution(arr2));
        System.out.println("arr3 : " + solution(arr3));
        System.out.println("arr4 : " + solution(arr4));
        System.out.println("arr5 : " + solution(arr5));

    }
}
