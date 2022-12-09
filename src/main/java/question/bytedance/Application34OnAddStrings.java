package question.bytedance;

/**
 * @Description: 415. 字符串相加
 * @Author 何鑫
 * @Date 2022/12/8 16:51
 */
public class Application34OnAddStrings {
    /**
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
     * <p>
     * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：num1 = "11", num2 = "123"
     * 输出："134"
     * 示例 2：
     * <p>
     * 输入：num1 = "456", num2 = "77"
     * 输出："533"
     * 示例 3：
     * <p>
     * 输入：num1 = "0", num2 = "0"
     * 输出："0"
     *  
     * <p>
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= num1.length, num2.length <= 104
     * num1 和num2 都只包含数字 0-9
     * num1 和num2 都不包含任何前导零
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/add-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        public String addStrings(String num1, String num2) {
            int p = num1.length() - 1;
            int q = num2.length() - 1;
            char[] charA = num1.toCharArray();
            char[] charB = num2.toCharArray();
            int tempAdd = 0;
            StringBuilder res = new StringBuilder("");

            while (p >= 0 || q >= 0) {

                int tempA = p >= 0 ? charA[p] - '0' : 0;
                int tempB = q >= 0 ? charB[q] - '0' : 0;

                int tempAns = tempA + tempB + tempAdd;
                tempAdd = tempAns / 10;
                tempAns = tempAns % 10;
                res.append(tempAns);
                p--;
                q--;
            }
            if(tempAdd == 1){
                res.append(1);
            }
            return res.reverse().toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.addStrings("123", "023");
        System.out.println(s);

    }
}
