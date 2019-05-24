package 编程题.动态规划.DP与DFS;

import java.util.Scanner;

/**
 * @author LIFAN
 * 2019/5/24 20:38
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 *
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 *
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *
 * DFS解法：对是否包含coins[n-1]进行讨论，然后递归值conis[n-2]，直至conis[0]。
 */

public class DFS {
    private static int minNum = 0x7fffffff;

    public static void coinNum(int[] coins, int amount, int end, int num){
        if (end < 0){
            return;
        }
        if (amount == 0){
            if (num < minNum){
                minNum = num;
            }
        }else {
            if(num > minNum)  return; // 大于最小次数，不再递归。
            for(int i = end; i > -1; i--){
                if(amount >= coins[i]){
                    coinNum(coins, amount - coins[i], i, num+1); //包含coins[i]的情况
                }
            }

        }
    }

    public static int coinChange(int[] coins, int amount) {

        coinNum(coins, amount, coins.length-1, 0);

        if (minNum == 0x7fffffff){
            return -1;

        }else{
            return minNum;
        }

    }

    public static void main(String[] args){
        int[] coins = new int[3];
        coins[0] = 1;
        coins[1] = 2;
        coins[2] = 5;
        System.out.println(coinChange(coins,11));
    }

}
