package 编程题.动态规划;

import java.util.Scanner;

/**
 * @Author: LiFan
 * @Date: 2019/2/21
 */

//小Q的歌单

//小Q有X首长度为A的不同的歌和Y首长度为B的不同的歌，现在小Q想用这些歌组成一个总长度正好为K的歌单，
// 每首歌最多只能在歌单中出现一次，在不考虑歌单内歌曲的先后顺序的情况下，请问有多少种组成歌单的方法。

//对于K，如果从X个A中取出i个A之后的差刚好能够除以B，并且（K-A*i）/B结果小于B的个数Y的话，
// 那么就可以取。结果的个数为：组合C(X,i)*C(Y,（K-A*i）/B)
//此时算的C就是杨辉三角的计算方法。对于每一行n和每一列m来说，就是从n个中取出m个的组合个数。
public class songsList {
    private static long[][] arr = new long[101][101];

    //构建杨辉三角
    private static void Initial(long[][] array){
        array[0][0] = 1;
        for(int i = 1;i <= 100;i++){
            array[i][0] = 1;
            for(int j = 1;j <= 100;j++){
                array[i][j] =(array[i-1][j-1] + array[i-1][j])%1000000007;;
            }
        }
    }

    private static long Calculate(int K, int A, int X, int B, int Y){
        long result = 0;
        int length;
        for (int i = 0; i <= X; i++){
            length = K - A * i;
            if (length >= 0 && length % B == 0 && length / B <= Y){
                result += (arr[X][i] * arr[Y][length / B])% 1000000007;
            }
        }
        return result % 1000000007;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        int A = scan.nextInt();
        int X = scan.nextInt();
        int B = scan.nextInt();
        int Y = scan.nextInt();
        Initial(arr);
        System.out.println(Calculate(k,A,X,B,Y));
    }
}
