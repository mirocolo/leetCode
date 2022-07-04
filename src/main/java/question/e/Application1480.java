package question.e;

import java.util.Arrays;

/**
 * @Description:
 * @Author 何鑫
 * @Date 2022/7/1 15:05
 */
public class Application1480 {
    public int[] runningSum(int[] nums) {
        int length = nums.length;
        if(length<=1){
            return nums;
        }
        for (int i = 1; i < length; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }

    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(2*sum+nums[i] == total){
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
