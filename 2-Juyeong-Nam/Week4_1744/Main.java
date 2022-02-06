import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] nums = new Integer[sc.nextInt()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        int sum = 0;
        Arrays.sort(nums, Collections.reverseOrder());
        ArrayList<Integer> pair = new ArrayList<>();
        for (int i = 0; (i < nums.length) && (nums[i] > 0); i++) {
            if (nums[i] > 1) {
                if (pair.isEmpty()) {
                    if ((i + 1 < nums.length) && (nums[i + 1] > 1)) {
                        pair.add(nums[i]);
                    } else {
                        sum += nums[i];
                    }
                }else {
                    pair.add(nums[i]);
                    sum += pair.get(0) * pair.get(1);
                    pair.clear();
                }
            }else {
                sum ++;
            }
        }
        boolean isOdd = false;
        for(int i = nums.length - 1; (i > -1) && (nums[i] < 1); i--) {
            if(nums[i] < 0) {
                if (pair.isEmpty()) {
                    if ((i - 1 > -1) && (nums[i - 1] < 0)) {
                        pair.add(nums[i]);
                    } else {
                        sum += nums[i];
                        isOdd = true;
                    }
                }else {
                    pair.add(nums[i]);
                    sum += pair.get(0) * pair.get(1);
                    pair.clear();
                }
            }else if(isOdd){
                sum -= nums[i + 1];
            }
        }
        System.out.println(sum);
    }
}
