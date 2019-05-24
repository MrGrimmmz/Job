package 编程题.动态规划.DP与DFS;

/**
 * @author LIFAN
 * 2019/5/24 21:02
 * DP解法，主要对amount进行讨论，通过递归算出amount-coin 的值来的出最终结果。
 */
public class DP {
    private static int coinNum(int[] coins, int amount, int[] result){

        if (amount < 0) return -1;

        if (amount == 0) return 0;

        if (result[amount-1] != 0) return result[amount-1];

        int min = 0x7fffffff;

        for (int coin : coins){
            int tmp = coinNum(coins, amount-coin, result);
            if (tmp >= 0 && tmp < min){
                min = tmp + 1;
            }
        }
        result[amount-1] = (min == 0x7fffffff) ? -1 : min;
        return result[amount-1];
    }


    public static int coinChange(int[] coins, int amount) {
        return coinNum(coins, amount, new int[amount]);
    }

    public static void main(String[] args){
        int[] coins = new int[3];

        coins[1] = 2;
        coins[0] = 1;
        coins[2] = 5;
        System.out.println(coinChange(coins,11));
    }

}
