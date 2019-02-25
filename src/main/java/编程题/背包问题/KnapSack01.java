package 编程题.背包问题;

/**
 * @Author: LiFan
 * @Date: 2019/2/21
 */

// 背包问题
// w(n)表示重量 v(n)表示价值，C表示包容量
//递归
//我们用F(n,C)表示将前n个物品放进容量为C的背包里，得到的最大的价值。
//我们用自顶向下的角度来看，假如我们已经进行到了最后一步（即求解将n 个物品放到背包里获得的最大价值），此时我们便有两种选择
// 不放第n个物品，此时总价值为F(n−1,C)
//放置第n个物品，此时总价值为v(n)+F(n−1,C−w(n))
// F(i,C)=max(F(i−1,C),v(i)+F(i−1,C−w(i)))
//动态规划算法
public class KnapSack01 {
    public static int knapSack(int[] w, int[] v, int C) {
        int size = w.length;
        if (size == 0) {
            return 0;
        }

        //构造 F(i,C)的数组
        int[][] dp = new int[size][C + 1];
        //初始化第一行
        //仅考虑容量为C的背包放第0个物品的情况
        for (int i = 0; i <= C; i++) {
            dp[0][i] = w[0] <= i ? v[0] : 0;
        }
        //填充其他行和列
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= C; j++) {
                if(w[i] > j){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], v[i] + dp[i - 1][j - w[i]]);
                }
            }
        }
        return dp[size - 1][C];
    }

    public static void main(String[] args) {
//        int[] w = {2, 1, 3, 2};
//        int[] v = {12, 10, 20, 15};
        int[] w = {1,2,3};
        int[] v = {6,10,12};
        System.out.println(knapSack(w, v, 5));
    }

}
