package question.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author 何鑫
 * @Date 2022/12/5 16:29
 */
public class Application16OnLengthOfLongestSubstring {

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int length = s.length();
            Map<Character, Integer> map = new HashMap<>();
            int ans = 0;
            int left = 0;
            for (int i = 0; i < length; i++) {
                char key = s.charAt(i);
                if (map.containsKey(key)) {
                    left = Math.max(left, map.get(key) + 1);
                }
                ans = Math.max(ans, i - left + 1);
                map.put(key, i);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.lengthOfLongestSubstring("acdabcdbcdf");
    }
}
