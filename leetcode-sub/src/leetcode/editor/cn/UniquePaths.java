package leetcode.editor.cn;

//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 例如，上图是一个7 x 3 的网格。有多少可能的路径？ 
//
// 
//
// 示例 1: 
//
// 输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 2: 
//
// 输入: m = 7, n = 3
//输出: 28 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10 ^ 9 
// 
// Related Topics 数组 动态规划 
// 👍 718 👎 0

public class UniquePaths{
    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //动态规划的关键：
    //    1.最优子结构opt[n] = best_of(opt[n-1], opt[n-2]...);
    //    2.存储中间状态opt[i]
    //    3.递推公式
    //使用递归是自顶向下一步一步找
    //使用动态递推则是自底向上找。这个棋盘里，最靠近终点的两个点AB的走法分别是多少，然后往上一层，最靠近AB的点的走法是多少
    //最终得到递推公式：dp[i][j] = dp[i+1][j] + dp[i][j+1];
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][n-1] = 1;
        for (int j = 0; j < n; j++) dp[m-1][j] = 1;
        for (int i = m - 2; i >= 0; i--){
            for (int j = n - 2; j >= 0; j--){
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}