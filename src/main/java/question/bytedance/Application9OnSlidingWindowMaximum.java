package question.bytedance;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Description: 滑动窗口最大值
 * @Author 何鑫
 * @Date 2022/11/29 22:15
 */
public class Application9OnSlidingWindowMaximum {

    public static void main(String[] args) {
        Application9OnSlidingWindowMaximum application9OnSlidingWindowMaximum=new Application9OnSlidingWindowMaximum();

        Solution solution=application9OnSlidingWindowMaximum.new Solution();
        solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);

        Solution2 solution2 = application9OnSlidingWindowMaximum.new Solution2();;
        solution2.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
                public int compare(int[] pair1, int[] pair2) {
                    return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
                }
            });
            for (int i = 0; i < k; ++i) {
                pq.offer(new int[]{nums[i], i});
            }
            int[] ans = new int[n - k + 1];
            ans[0] = pq.peek()[0];
            for (int i = k; i < n; ++i) {
                pq.offer(new int[]{nums[i], i});
                while (pq.peek()[1] <= i - k) {
                    pq.poll();
                }
                ans[i - k + 1] = pq.peek()[0];
            }
            return ans;
        }
    }

    class Solution2 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            Deque<Integer> deque = new LinkedList<Integer>();
            for (int i = 0; i < k; ++i) {
                // 右边窗口的值如果已经比当前最大值的大 那么一定晚于当前值离开此队列 无用值移除
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
            }

            int[] ans = new int[n - k + 1];
            ans[0] = nums[deque.peekFirst()];
            for (int i = k; i < n; ++i) {
                // 右边窗口的值如果已经比当前最大值的大 那么一定晚于当前值离开此队列 无用值移除
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                while (deque.peekFirst() <= i - k) {
                    deque.pollFirst();
                }
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
            return ans;
        }
    }



}
