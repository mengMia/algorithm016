package leetcode.editor.cn;

//假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干
//的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满
//足越多数量的孩子，并输出这个最大数值。
//
// 注意：
//
// 你可以假设胃口值为正。
//一个小朋友最多只能拥有一块饼干。
//
// 示例 1:
//
//
//输入: [1,2,3], [1,1]
//
//输出: 1
//
//解释:
//你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
//虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
//所以你应该输出1。
//
//
// 示例 2:
//
//
//输入: [1,2], [1,2,3]
//
//输出: 2
//
//解释:
//你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
//你拥有的饼干数量和尺寸都足以让所有孩子满足。
//所以你应该输出2.
//
// Related Topics 贪心算法
// 👍 202 👎 0

import java.util.Arrays;

public class AssignCookies{
    public static void main(String[] args) {
        Solution solution = new AssignCookies().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        /**
         * 这三种的思路都类似，这种是先找最大的饼干满足胃口最大的孩子，如果找到了，则饼干--，孩子--，否则孩子--（这个孩子分发不到饼干）
         */
        Arrays.sort(s);
        Arrays.sort(g);
        int j = s.length - 1;
        int count = 0;
        for (int i = g.length - 1; i >= 0 && j >= 0; i--){
            if (s[j] >= g[i]){
                count++;
                j--;
            }
        }
        return count;
    }
    /*public int findContentChildren(int[] children, int[] cookie) {
        //思路大致类似，只是从最小胃口的孩子开始分发满足条件的最小饼干，如果满足了则饼干++，孩子++，
        // 如果不满足，则饼干++
        // 能够分发的孩子数量，即为最后的结果
        if (children == null || cookie == null || children.length == 0 || cookie.length == 0) return 0;
        Arrays.sort(children);
        Arrays.sort(cookie);
        int idx_child = 0;
        for (int idx_cookie = 0; idx_child < children.length && idx_cookie < cookie.length; idx_cookie++){
            if (cookie[idx_cookie] >= children[idx_child]) idx_child++;
        }
        return  idx_child;
    }*/
    /*public int findContentChildren(int[] children, int[] cookie) {
        //先要对饼干和孩子的胃口值进行排序，要找出能够满足孩子胃口值最小的饼干，这样才可以得到最优解
        // 遍历饼干和孩子的胃口值，如果满足饼干>=孩子的胃口值，则计数加1，同时饼干计数往后移动，孩子计数往后移动；否则只往后移动饼干
        if (children == null || cookie == null || children.length == 0 || cookie.length == 0) return 0;
        Arrays.sort(children);
        Arrays.sort(cookie);
        int idx_child= 0, idx_cookie = 0, count = 0;
        while (idx_child < children.length && idx_cookie < cookie.length){
            if (cookie[idx_cookie] >= children[idx_child]){
                count++;
                idx_child++;
                idx_cookie++;
            }else idx_cookie++;
        }
        return count;
    }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}