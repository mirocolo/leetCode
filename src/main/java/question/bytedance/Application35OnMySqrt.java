package question.bytedance;

/**
 * @Description: 69. x 的平方根
 * @Author 何鑫
 * @Date 2022/12/8 17:27
 */
public class Application35OnMySqrt {
    /**
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     * <p>
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     * <p>
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：x = 4
     * 输出：2
     * 示例 2：
     * <p>
     * 输入：x = 8
     * 输出：2
     * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
     *  
     * <p>
     * 提示：
     * <p>
     * 0 <= x <= 231 - 1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/sqrtx
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {
        public int mySqrt(int x) {
            int l = 0, r = x, ans = -1;
            while (r > l) {
                int mid = l + (r - 1) / 2;
                int tempRes = mid * mid;
                if(tempRes == x){
                    return mid;
                }else if(tempRes < x){
                    ans = mid;
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
            return ans;
        }
    }
}
