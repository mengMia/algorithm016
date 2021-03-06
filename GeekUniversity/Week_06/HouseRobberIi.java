package leetcode.editor.cn;

//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 401 👎 0

public class HouseRobberIi{
    public static void main(String[] args) {
        Solution solution = new HouseRobberIi().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //相对于打家劫舍I，可以考虑为两个打家劫舍I，即一个房子的index是从1~（n-1），另一个是从0~{n-2}，分别计算，最后取最大值即可
    public int rob(int[] nums) {
        //order: prev2, prev1, num
        if (nums.length <= 1) return nums.length == 0 ? 0 : nums[0];
        int prev2 = 0, prev1 = 0, sum = 0;
        for (int i = 0; i < nums.length - 1; i++){
            sum = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = sum;
        }

        int pre2 = 0, pre1 = 0, sum1 = 0;
        for (int i = 1; i < nums.length; i++){
            sum1 = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = sum1;
        }
        return Math.max(sum, sum1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}