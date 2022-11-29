package question.bytedance;

/**
 * @Description:
 * @Author 何鑫
 * @Date 2022/11/25 10:17
 */
public class Application3OnSearchInRotatedSortedArray {
    /**
     * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
     * <p>
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
     * <p>
     * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
     * <p>
     * 你必须尽可能减少整个操作步骤。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/search-in-rotated-sorted-array-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean search(int[] nums,int target){
        return searchResInt(nums,target)!=-1;
    }

    public int searchResInt(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 若数组内 存在相同数字 导致有序数组无法定位 则收敛当前的左右扫描区间
            if(nums[l]==nums[mid] && nums[r] == nums[mid]){
                l++;
                r--;
            }
            else if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid]){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
                // 左半边有序
            } else {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
                // 右半边有序
            }
        }
        return -1;
    }
}
