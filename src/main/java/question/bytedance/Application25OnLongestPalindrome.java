package question.bytedance;

/**
 * @Description: 最长回文子串
 * @Author 何鑫
 * @Date 2022/12/7 13:43
 */
public class Application25OnLongestPalindrome {
    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     * <p>
     * 输入：s = "cbbd"
     * 输出："bb"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {
        /**
         * 什么是回文串？
         * 长度为 1 回文
         * 长度为 2 Si = Sj 回文
         * 长度大于2 Si-1 = Sj+1
         */
        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2) {
                return s;
            }
            int maxLen = 1;
            int begin = 0;
            boolean[][] dp = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }
            char[] chars = s.toCharArray();
            for (int currLen = 2; currLen <= len; currLen++) {
                // 左界
                for (int i = 0; i < len && i+maxLen<=len; i++) {
                    // 右边界
                    int j = currLen + i - 1;
                    if (j >= len) {
                        break;
                    }
                    if (chars[i] != chars[j]) {
                        dp[i][j] = false;
                    } else {
                        if (currLen < 3) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }
                    if (dp[i][j] && currLen > maxLen) {
                        maxLen = currLen;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin + maxLen);

        }
    }


    class Solution2 {
        public String longestPalindrome(String s) {
            int length = s.length();
            if (s == null || length < 1) {
                return "";
            }
            int start = 0, end = 0;
            for (int i = 0; i < length; i++) {
                int len1 = expandAroundCenter(s, i, i);
                int len2 = expandAroundCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
                if(i + 1 + end - start + 1 > length){
                    break;
                }
            }
            return s.substring(start, end + 1);
        }

        public int expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                --left;
                ++right;
            }
            return right - left - 1;
        }
    }

}
