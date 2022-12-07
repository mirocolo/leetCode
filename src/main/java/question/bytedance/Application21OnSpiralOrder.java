package question.bytedance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 54. 螺旋矩阵
 * @Author 何鑫
 * @Date 2022/12/7 9:43
 */
public class Application21OnSpiralOrder {

    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     * <p>
     * <p>
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     *  
     * <p>
     * 提示：
     * <p>
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 10
     * -100 <= matrix[i][j] <= 100
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/spiral-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return Collections.emptyList();
            }
            List<Integer> ans = new ArrayList<>();
            int left = 0, right = matrix[0].length - 1, head = 0, tail = matrix.length - 1;
            while (left <= right && head <= tail) {
                for (int i = left; i <= right; i++) {
                    int matrix1 = matrix[head][i];
                    ans.add(matrix1);
                }
                for (int i = head + 1; i <= tail; i++) {
                    ans.add(matrix[i][right]);
                }
                if (head < tail && left < right) {
                    for (int i = right - 1; i >= left; i--) {
                        ans.add(matrix[tail][i]);
                    }
                    for (int i = tail - 1; i >= head + 1; i--) {
                        ans.add(matrix[i][left]);
                    }
                }

                left++;
                right--;
                head++;
                tail--;
            }

            return ans;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            List<Integer> list = solution.spiralOrder(new int[][]{
                    new int[]{1, 2, 3},
                    new int[]{4, 5, 6},
                    new int[]{7, 8, 9},
            });
            System.out.println(list);
        }
    }

}
