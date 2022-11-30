package question.bytedance;

import java.util.Arrays;

/**
 * @Description: 游戏中弱角色的数量
 * @Author 何鑫
 * @Date 2022/11/30 9:52
 */
public class Application10OnWeakCharacterInGame {
    /**
     * 你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。给你一个二维整数数组 properties ，其中 properties[i] = [attacki, defensei] 表示游戏中第 i 个角色的属性。
     *
     * 如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，则认为该角色为 弱角色 。更正式地，如果认为角色 i 弱于 存在的另一个角色 j ，那么 attackj > attacki 且 defensej > defensei 。
     *
     * 返回 弱角色 的数量。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：properties = [[5,5],[6,3],[3,6]]
     * 输出：0
     * 解释：不存在攻击和防御都严格高于其他角色的角色。
     * 示例 2：
     *
     * 输入：properties = [[2,2],[3,3]]
     * 输出：1
     * 解释：第一个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
     * 示例 3：
     *
     * 输入：properties = [[1,5],[10,4],[4,3]]
     * 输出：1
     * 解释：第三个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
     *  
     *
     * 提示：
     *
     * 2 <= properties.length <= 105
     * properties[i].length == 2
     * 1 <= attacki, defensei <= 105
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/the-number-of-weak-characters-in-the-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int[][] properties = new int[][]{
                new int[]{7,1},
                new int[]{5,3},
                new int[]{2,1},
        };
//        Arrays.sort(properties, (o1, o2) -> o1[0] == o2[0] ? (o1[1] - o2[1]) : (o2[0] - o1[0]));
//        for (int i = 0; i < properties.length; i++) {
//            System.out.println(Arrays.toString(properties[i]));
//        }
        Application10OnWeakCharacterInGame application10OnWeakCharacterInGame = new Application10OnWeakCharacterInGame();
        Solution solution = application10OnWeakCharacterInGame.new Solution();
        int i = solution.numberOfWeakCharacters(properties);
        System.out.println(i);

    }

    class Solution {
        public int numberOfWeakCharacters(int[][] properties) {
            // 分析题意
            // 预排序 攻击大的排在前方 相同攻击 防御小的排在前方
            // 依次遍历 取到攻击力相同组内的 最大防御 去筛选下一组的弱角色

            Arrays.sort(properties, (o1, o2) -> o1[0] == o2[0] ? (o1[1] - o2[1]) : (o2[0] - o1[0]));
            int maxDef = 0;
            int ans = 0;
            for (int[] p : properties) {
                if (p[1] < maxDef) {
                    ans++;
                } else {
                    maxDef = p[1];
                }
            }
            return ans;
        }
    }

}
