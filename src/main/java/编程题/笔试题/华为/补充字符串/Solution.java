package 编程题.笔试题.华为.补充字符串;

/**
 * @author LIFAN
 * 2019/4/15 18:49
 */
import java.util.Scanner;

/**
 * @Author ifcc
 * @Date 2019-04-10
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {

    static int result=0;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] paths = new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                paths[i][j]=scanner.nextInt();
            }
        }
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        int w = scanner.nextInt();


        solution(paths,x,y,z,w);
        System.out.println(result%((int)Math.pow(10,9)));
    }

    public static void solution(int[][] m, int i, int j, int z, int w){
        int N=m.length;
        int M=m[0].length;
        if (i==z&&j==w){
            result++;
        }
        if (i<0||i>=N||j<0||j>=M){
            return;
        }

        if (i<N-1&&m[i+1][j]>m[i][j]){
            solution(m,i+1,j,z,w);
        }
        if (i>0&&m[i-1][j]>m[i][j]){
            solution(m,i-1,j,z,w);
        }
        if (j<M-1&&m[i][j+1]>m[i][j]){
            solution(m,i,j+1,z,w);
        }
        if (j>0&&m[i][j-1]>m[i][j]){
            solution(m,i,j-1,z,w);
        }

    }
}
