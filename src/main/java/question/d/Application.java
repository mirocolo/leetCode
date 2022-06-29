package question.d;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */
public class Application {

    /**
     * 暴力法
     *
     * @param s
     * @return
     */
    public String longestPalindromeVer1(String s) {

        if (s == null) {
            return "";
        }
        int length = s.length();
        if (length < 1) {
            return "";
        }
        if (length == 1) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }

            }

        }
        return s.substring(begin, begin + maxLen);
    }

    private boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String longestPalindromeVer2(String s) {
        if (s == null) {
            return "";
        }
        int length = s.length();
        if (length < 1) {
            return "";
        }
        if (length == 1) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[length][length];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        //只有 s[i+1:j-1]s[i+1:j−1] 是回文串，并且 ss 的第 ii 和 jj 个字母相同时，s[i:j]s[i:j] 才会是回文串。
        char[] charArray = s.toCharArray();
        for (int L = 2; L < length; L++) {
            for (int i = 0; i < length; i++) {
                int j = L + i - 1;
                if( j >= length){
                    break;
                }
                if(charArray[i] !=charArray[j]){
                    dp[i][j] = false;
                }else {
                    if(j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }


            }
        }

        return s.substring(begin, begin + maxLen);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
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
