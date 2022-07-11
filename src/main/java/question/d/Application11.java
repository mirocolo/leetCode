package question.d;

/**
 * @Description: 盛最多水的容器
 * @Author 何鑫
 * @Date 2022/7/11 11:07
 */
public class Application11 {
    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * <p>
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 返回容器可以储存的最大水量。
     * <p>
     * 说明：你不能倾斜容器。
     */
    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++])
                    : Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}
