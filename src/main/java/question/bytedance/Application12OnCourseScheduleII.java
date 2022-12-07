package question.bytedance;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 课程表
 * @Author 何鑫
 * @Date 2022/11/30 16:11
 */
public class Application12OnCourseScheduleII {

    /**
     * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
     *
     * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
     * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：numCourses = 2, prerequisites = [[1,0]]
     * 输出：[0,1]
     * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
     * 示例 2：
     *
     * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
     * 输出：[0,2,1,3]
     * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
     * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
     * 示例 3：
     *
     * 输入：numCourses = 1, prerequisites = []
     * 输出：[0]
     *  
     *
     * 提示：
     * 1 <= numCourses <= 2000
     * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
     * prerequisites[i].length == 2
     * 0 <= ai, bi < numCourses
     * ai != bi
     * 所有[ai, bi] 互不相同
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/course-schedule-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */

    class Solution {

        // 广度优先搜索
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<List<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                edges.add(new ArrayList<>());
            }
            int[] nodeEdgeNum = new int[numCourses];
            int[] result =new int[numCourses];
            int index = 0 ;
            for (int[] info : prerequisites) {
                edges.get(info[0]).add(info[1]);
                ++ nodeEdgeNum[info[0]];
            }
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < numCourses; i++) {
                if(nodeEdgeNum[i] == 0){
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()){
                Integer poll = queue.poll();
                nodeEdgeNum[poll]--;
                result[index++] = poll;
                for (int v: edges.get(poll)) {
                    --nodeEdgeNum[v];
                    // 如果相邻节点 v 的入度为 0，就可以选 v 对应的课程了
                    if (nodeEdgeNum[v] == 0) {
                        queue.offer(v);
                    }
                }

            }
            if(index!=numCourses){
                return new int[0];
            }
            return result;

        }
    }

    class Solution2 {
        // 存储有向图
        List<List<Integer>> edges;
        // 标记每个节点的状态：0=未搜索，1=搜索中，2=已完成
        int[] visited;
        // 用数组来模拟栈，下标 n-1 为栈底，0 为栈顶
        int[] result;
        // 判断有向图中是否有环
        boolean valid;
        // 栈下标
        int index;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            // 初始化数据结构
            edges = new ArrayList<>();
            visited = new int[numCourses];
            result = new int[numCourses];
            valid = true;
            index = numCourses-1;
            for (int i = 0; i < numCourses; i++) {
                edges.add(new ArrayList<>());
                visited[i] = 0;
            }
            for (int[] prerequisite : prerequisites) {
                // 有向图 记录 节点的出度方向
                edges.get(prerequisite[1]).add(prerequisite[0]);
            }

            for (int i = 0; i < numCourses && valid; i++) {
                if(visited[i]==0){
                    dfs(i);
                }

            }
            if(!valid){
                return new int[0];
            }
            return result;


        }

        public void dfs(int u){
            visited[u] = 1;
            List<Integer> newNodeList = edges.get(u);
            for (Integer v : newNodeList) {
                if(visited[v] == 0){
                    dfs(v);
                    if(!valid){
                        return;
                    }
                }else if(visited[v] == 1){
                    valid = false;
                    return;
                }

            }
            visited[u] = 2;
            result[index--] = u;
        }
    }
}
