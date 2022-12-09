package question.dymaicprograming;

/**
 * @Description: 动态规划
 * @Author 何鑫
 * @Date 2022/6/21 9:59
 */
public class Application {

    /**
     * 【无后效性】　　一旦f(n)确定，“我们如何凑出f(n)”就再也用不着了。
     * 要求出f(15)，只需要知道f(14),f(10),f(4)的值，而f(14),f(10),f(4)是如何算出来的，对之后的问题没有影响。
     * “未来与过去无关”，这就是无后效性。　　（严格定义：如果给定某一阶段的状态，则在这一阶段以后过程的发展不受这阶段以前各段状态的影响。）
     * 【最优子结构】　　回顾我们对f(n)的定义：我们记“凑出n所需的最少钞票数量”为f(n).　　f(n)的定义就已经蕴含了“最优”。利用w=14,10,4的最优解，我们即可算出w=15的最优解。
     * 大问题的最优解可以由小问题的最优解推出，这个性质叫做“最优子结构性质”。
     * 引入这两个概念之后，我们如何判断一个问题能否使用DP解决呢？
     * 能将大问题拆成几个小问题，且满足无后效性、最优子结构性质。
     * <p>
     * <p>
     * 假设您是个土豪，身上带了足够的1、5、10、20、50、100元面值的钞票。现在您的目标是凑出某个金额w，需要用到尽量少的钞票。
     * 　将一个问题拆成几个子问题，分别求解这些子问题，即可推断出大问题的解。
     * F(w) = min{(F(w-1),F(w-5),F(w-10),F(w-20),F(w-50),F(w-100)}+1)
     */

    int moneyNum(int money) {
        if (money <= 0) {
            return 0;
        }

        int[] a = new int[money + 1];
        a[0] = 0;
        int num;
        for (int i = 1; i <= money; i++) {
            num = Integer.MAX_VALUE;
            if (i - 1 >= 0) {
                num = Math.min(num, a[i - 1] + 1);
            }
            if (i - 5 >= 0) {
                num = Math.min(num, a[i - 5] + 1);
            }
            if (i - 10 >= 0) {
                num = Math.min(num, a[i - 10] + 1);
            }
            if (i - 20 >= 0) {
                num = Math.min(num, a[i - 20] + 1);
            }
            if (i - 50 >= 0) {
                num = Math.min(num, a[i - 50] + 1);
            }
            if (i - 100 >= 0) {
                num = Math.min(num, a[i - 100] + 1);
            }
            a[i] = num;
        }
        return a[money];
    }

    /**
     * 最长上升子序列，O(N*N)
     */
    public int lengthOfLIS(int[] upArray) {
        if (null == upArray) {
            return 0;
        }
        int length = upArray.length;
        if (length == 1) {
            return 1;
        }
        int[] f = new int[length];
        for (int i = 0; i < length; i++) {
            f[i]=1;
        }
        int ans = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (upArray[j] < upArray[i] && f[i] < f[j] + 1) {
                    f[i] = f[j] + 1;
                }
            }
        }

        for(int i =0 ; i<length;i++){
            ans = Math.max(ans,f[i]);
        }
        return ans;
    }
    /**
     * 最长上升子序列，O(N*logN)
     */
    public int lengthOfLISVer2(int[] upArray){
        if (null == upArray) {
            return 0;
        }
        int length = upArray.length;
        if (length == 1) {
            return 1;
        }
        // tail 数组的定义：长度为 i + 1 的上升子序列的末尾最小是几
        int[] tail= new int[length];
        // 遍历第 1 个数，直接放在有序数组 tail 的开头
        tail[0] = upArray[0];
        // end 表示有序数组 tail 的最后一个已经赋值元素的索引
        int end = 0;
        for (int i = 1; i < length; i++) {
            // 【逻辑 1】比 tail 数组实际有效的末尾的那个元素还大
            if (upArray[i] > tail[end]) {
                // 直接添加在那个元素的后面，所以 end 先加 1
                end++;
                tail[end] = upArray[i];
            } else {
                // 使用二分查找法，在有序数组 tail 中
                // 找到第 1 个大于等于 nums[i] 的元素，尝试让那个元素更小
                int left = 0;
                int right = end;
                while (left < right) {
                    // 选左中位数不是偶然，而是有原因的，原因请见 LeetCode 第 35 题题解
                    // int mid = left + (right - left) / 2;
                    int mid = left + ((right - left) >>> 1);
                    if (tail[mid] < upArray[i]) {
                        // 中位数肯定不是要找的数，把它写在分支的前面
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                // 走到这里是因为 【逻辑 1】 的反面，因此一定能找到第 1 个大于等于 nums[i] 的元素
                // 因此，无需再单独判断
                tail[left] = upArray[i];

            }
        }
        // 此时 end 是有序数组 tail 最后一个元素的索引
        // 题目要求返回的是长度，因此 +1 后返回
        end++;
        return end;
    }




}
