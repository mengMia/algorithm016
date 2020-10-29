package leetcode.editor.cn;

//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 
//
// 上图是一个部分填充的有效的数独。 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 示例 1: 
//
// 输入:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: false
//解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
//     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。 
//
// 说明: 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 给定数独序列只包含数字 1-9 和字符 '.' 。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 
// 👍 435 👎 0

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku{
    public static void main(String[] args) {
        Solution solution = new ValidSudoku().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //参考leetcode题解
    //'4' in row 7 is encoded as "(4)7".
    //'4' in column 7 is encoded as "7(4)".
    //'4' in the top-right block is encoded as "0(4)2"
    public boolean isValidSudoku(char[][] board){
        Set seen = new HashSet();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                char num = board[i][j];
                if (num != '.'){
                    if (!seen.add(num + "in row" + i) ||
                        !seen.add(num + "in col" + j) ||
                        !seen.add(num + "in_box" + i / 3 + "_" + j / 3))
                        return false;
                }
            }
        }
        return true;
    }
    /*public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] != '.'){
                    int num = board[i][j] - '1';
                    int box_indx = (i / 3) * 3 + j / 3;
                    if (row[i][num] == 1) return false;
                    if (col[j][num] == 1) return false;
                    if (box[box_indx][num] == 1) return false;

                    row[i][num] = 1;
                    col[j][num] = 1;
                    box[box_indx][num] = 1;
                }
            }
        }
        return true;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}