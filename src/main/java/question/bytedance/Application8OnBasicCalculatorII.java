package question.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description:
 * @Author 何鑫
 * @Date 2022/11/29 13:51
 */
public class Application8OnBasicCalculatorII {
    /**
     * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
     * <p>
     * 整数除法仅保留整数部分。
     * <p>
     * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
     * <p>
     * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "3+2*2"
     * 输出：7
     * 示例 2：
     * <p>
     * 输入：s = " 3/2 "
     * 输出：1
     * 示例 3：
     * <p>
     * 输入：s = " 3+5 / 2 "
     * 输出：5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/basic-calculator-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        Solution2 solution2=new Solution2();
        int calculate = solution2.calculate("1+2*5/3+6/4*2");
        System.out.println(calculate);
    }

    static class Solution2 {

        static HashMap<Character, Integer> map = new HashMap<Character, Integer>() {
            {
                put('+', 1);   //定义运算符的优先级
                put('-', 1);
                put('*', 2);
                put('/', 2);
            }
        };

        static void calcForTwoNum(Stack<Integer> num, Stack<Character> op) {
            int b = num.pop();
            int a = num.pop();
            char c = op.pop();
            int r = 0;
            if (c == '+') r = a + b;
            else if (c == '-') r = a - b;
            else if (c == '*') r = a * b;
            else r = a / b;
            num.add(r);
        }

        public int calculate(String s) {
            Stack<Integer> num = new Stack<Integer>();
            Stack<Character> op = new Stack<Character>();
            s = '0' + s; // 对开头是负数的处理
            int length = s.length();
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (c == ' ') continue;  //跳过空格
                if (Character.isDigit(c))  //c是数字,读取一个连续的数字
                {
                    int x = 0;
                    while (i < length && Character.isDigit(s.charAt(i))) {
                        x = x * 10 + s.charAt(i) - '0';
                        i ++ ;
                    }
                    i--;
                    num.add(x);
                }
                else{
                    //c是操作符
                    //op栈非空并且栈顶操作符优先级大于等于当前操作符c的优先级，进行eval()计算
                    while (!op.isEmpty() && map.get(op.peek()) >= map.get(c)) {
                        calcForTwoNum(num, op);
                    }
                    op.add(c);
                }
            }
            while (!op.isEmpty()) {
                calcForTwoNum(num, op);
            }
            return num.pop();
        }
    }


    static class Solution {
        // 使用 map 维护一个运算符优先级
        // 这里的优先级划分按照「数学」进行划分即可
        Map<Character, Integer> map = new HashMap<>() {{
            put('-', 1);
            put('+', 1);
            put('*', 2);
            put('/', 2);
            put('%', 2);
            put('^', 3);
        }};


        public int calculate(String s) {
            // 将所有的空格去掉
            s = s.replaceAll(" ", "");
            char[] cs = s.toCharArray();
            int n = s.length();
            // 存放所有的数字
            Deque<Integer> nums = new ArrayDeque<>();
            // 为了防止第一个数为负数，先往 nums 加个 0
            nums.addLast(0);
            // 存放所有「非数字以外」的操作
            Deque<Character> ops = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                char c = cs[i];
                if (c == '(') {
                    ops.addLast(c);
                } else if (c == ')') {
                    // 计算到最近一个左括号为止
                    while (!ops.isEmpty()) {
                        if (ops.peekLast() != '(') {
                            calc(nums, ops);
                        } else {
                            ops.pollLast();
                            break;
                        }
                    }
                } else {
                    if (isNumber(c)) {
                        int u = 0;
                        int j = i;
                        // 将从 i 位置开始后面的连续数字整体取出，加入 nums
                        while (j < n && isNumber(cs[j])) u = u * 10 + (cs[j++] - '0');
                        nums.addLast(u);
                        i = j - 1;
                    } else {
                        if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                            // 非法符号补0完成计算
                            nums.addLast(0);
                        }
                        // 有一个新操作要入栈时，先把栈内可以算的都算了
                        // 只有满足「栈内运算符」比「当前运算符」优先级高/同等，才进行运算
                        while (!ops.isEmpty() && ops.peekLast() != '(') {
                            char prev = ops.peekLast();
                            if (map.get(prev) >= map.get(c)) {
                                calc(nums, ops);
                            } else {
                                break;
                            }
                        }

                        ops.addLast(c);

                    }
                }
            }
            // 将剩余的计算完
            while (!ops.isEmpty()) calc(nums, ops);
            return nums.peekLast();
        }

        void calc(Deque<Integer> nums, Deque<Character> ops) {
            if (nums.isEmpty() || nums.size() < 2) {
                return;
            }
            if (ops.isEmpty()) {
                return;
            }
            int b = nums.pollLast();
            int a = nums.pollLast();
            char op = ops.pollLast();
            int ans = 0;
            if (op == '+') ans = a + b;
            else if (op == '-') ans = a - b;
            else if (op == '*') ans = a * b;
            else if (op == '/') ans = a / b;
            else if (op == '^') ans = (int) Math.pow(a, b);
            else if (op == '%') ans = a % b;
            nums.addLast(ans);
        }

        boolean isNumber(char c) {
            return Character.isDigit(c);
        }
    }

}
