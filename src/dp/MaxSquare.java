package dp;

/**
 * Created by Heiku on 2018/7/27
 */

/** LeetCode 221
 * 题目：Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *      （求二维数组中的最大面积正方形）
 *
 *      Input:
 *
 *      1 0 1 0 0
 *      1 0 1 1 1
 *      1 1 1 1 1
 *      1 0 0 1 0
 *
 *      Output: 4
 *
 * 思路：dp，状态转移方程 dp[i][j] = Math.min( Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j -1]) + 1
 */
public class MaxSquare {
    public int maximalSquare(char[][] matrix) {

        if (matrix.length <= 0)
            return 0;

        int n = matrix.length;
        int m = matrix[0].length;


        int[][] dp = new int[n + 1][m + 1];
        int result = 0;

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (matrix[i - 1][j - 1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        return result * result;
    }

    public static void main(String[] args) {
        char[][] c= {{'1'}};
        new MaxSquare().maximalSquare(c);
    }

}
