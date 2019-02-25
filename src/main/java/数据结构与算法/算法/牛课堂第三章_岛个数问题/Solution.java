package 数据结构与算法.算法.牛课堂第三章_岛个数问题;

/**
 * 给定一个二维数组，所有位置的值不是0就是1，规定每个位置可以和它上下左右位置上的值相连
 * 有一个叫做岛的概念，定义如下：
 * 连成一片的1，如果周围都是0，那么这一片1，构成一个岛
 * 求整张图上有多少个岛
 * @Author ifcc
 * @Date 2018-05-24
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){
        int[][] m={
                {0,1,0,1,0,0},
                {0,1,0,0,0,0},
                {0,1,1,1,0,0},
                {0,0,0,1,0,0},
        };
        int res = countIslands(m);
        System.out.println(res);
    }
    public static int countIslands(int[][] m){
        if (m==null||m[0]==null){
            return 0;
        }
        int N=m.length;
        int M=m[0].length;
        int res=0;
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (m[i][j]==1){
                    res++;
                    infect(m,i,j,N,M);
                }
            }
        }
        return res;
    }

    private static void infect(int[][] m, int i, int j, int N, int M) {
        if (i<0||i>=N||j<0||j>=M||m[i][j]!=1){
            return;
        }
        m[i][j]=2;
        infect(m,i+1,j,N,M);
        infect(m,i-1,j,N,M);
        infect(m,i,j+1,N,M);
        infect(m,i,j-1,N,M);
    }
}
