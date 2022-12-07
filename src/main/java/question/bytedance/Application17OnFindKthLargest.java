package question.bytedance;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @Description: 数组中第K大的元素
 * @Author 何鑫
 * @Date 2022/12/5 17:20
 */
public class Application17OnFindKthLargest {
    /**
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     *
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [3,2,1,5,6,4], k = 2
     * 输出: 5
     * 示例 2:
     *
     * 输入: [3,2,3,1,2,4,5,5,6], k = 4
     * 输出: 4
     *  
     *
     * 提示：
     *
     * 1 <= k <= nums.length <= 105
     * -104 <= nums[i] <= 104
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/kth-largest-element-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // 使用一个含有 k 个元素的最小堆，PriorityQueue 底层是动态数组，为了防止数组扩容产生消耗，可以先指定数组的长度
            PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.comparingInt(a->a));
            for (int i = 0; i < k; i++) {
                // 逐个将前 k 个元素添加到 minHeap 里
                queue.offer(nums[k]);
            }
            for (int i = k; i < nums.length;  i++) {
                // 看一眼，不拿出，因为有可能没有必要替换
                // 比最小值大 进入最小堆
                if(nums[i]>queue.peek()){
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
            // 取出堆顶 第k大的值
            return queue.peek();
        }
    }

    class Solution2 {
        public int findKthLargest(int[] nums, int k) {
            int len = nums.length;
            int target = len - k;

            int left = 0;
            int right = len - 1;

            return quickSort(nums,target,left,right);
        }

        private int quickSort(int[] nums, int k, int left, int right) {
            int q = randomPartition(nums,left,right);
            if(q == k){
                return nums[k];
            }
            return q < k ?  quickSort(nums,k,left+1,right):quickSort(nums,k,left,right-1);
        }

        private int randomPartition(int[] nums, int left, int right) {
            int randomIndex = left + random.nextInt(right - left + 1);
            swap(nums, left, randomIndex);
            return partition(nums,left,right);
        }

        private final static Random random = new Random(System.currentTimeMillis());
        private int partition(int[] nums, int left, int right) {
            // all in nums[left + 1..le) <= pivot;
            // all in nums(ge..right] >= pivot;
            int pivot = nums[left];
            int le = left + 1;
            int ge = right;

            while (true) {
                while (le <= ge && nums[le] < pivot) {
                    le++;
                }

                while (le <= ge && nums[ge] > pivot) {
                    ge--;
                }

                if (le >= ge) {
                    break;
                }
                swap (nums, le, ge);
                le++;
                ge--;
            }

            swap(nums, left, ge);
            return ge;
        }

        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }

}
