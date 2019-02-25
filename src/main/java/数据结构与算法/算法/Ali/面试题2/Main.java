package 数据结构与算法.算法.Ali.面试题2;
import java.util.*;
/**
 * 阿里巴巴客服管理员管理着n个客服小组，他需要为每一组安排客服24小时值班。为简单起见，假设每组只有2个客服，一天只需要1个客服上班，并且一些客服由于某些原因不能在同一天上班。
 我们已经对客服进行了编号，第i（i>=1&&i<=n）个组的客服编号为2*i-1和2*i。并且知道了m种如下约束关系：客服编号a和客服编号b不能一起上班。
 管理员需要聪明的你帮忙判断今天是否存在可行的方案，既满足m条约束关系，又能让每个组都有1个客服上班。
 输入：n(代表有n个组）
 m(m条约束关系），接下来会有m行
 a,b(代表a，b两位客服标号不能同时上班)
 输出：判断有没有可行方案：如果不可行输出no；如果可行输出yes
 举例：
 输入：
 4
 3
 1,4
 2,3
 7,3
 输出：yes
 * @Author ifcc
 * @Date 2018-05-11
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int m=Integer.parseInt(scanner.nextLine());
        HashMap<Integer, Integer> limit = new HashMap<Integer, Integer>();
        int[][] g = new int[2 * n+1][2 * n+1];
        for (int i=0;i<m;i++){
            String str = scanner.nextLine();
            String[] num = str.split(",");
            int input1=Integer.parseInt(num[0]);
            int input2=Integer.parseInt(num[1]);
            g[input1][input2]=1;
            g[input2][input1]=1;
        }
        int[] result=new int[n];
        for (int i=1;i<=n;i++){
            for (int j=i+1;j<=n;j++){
                if (g[i*2-1][j*2-1]==1&&g[i*2-1][j*2]==1&&g[i*2][j*2-1]==1&&g[i*2][j*2]==1){
                    System.out.println("no");
                    return;
                }
                if (g[i*2-1][j*2-1]==1&&g[i*2-1][j*2]==1){
                    if (result[i]==i*2-1){
                        System.out.println("no");
                        return;
                    }
                    result[i]=i*2;
                }else if (g[i*2][j*2-1]==1&&g[i*2][j*2]==1){
                    if (result[i]==i*2){
                        System.out.println("no");
                        return;
                    }
                    result[i]=i*2-1;
                }
                if (g[i*2-1][j*2-1]==1&&g[i*2][j*2-1]==1){
                    if (result[j]==j*2-1){
                        System.out.println("no");
                        return;
                    }
                    result[j]=j*2;
                }else if (g[i*2-1][j*2]==1&&g[i*2][j*2]==1){
                    if (result[j]==j*2){
                        System.out.println("no");
                        return;
                    }
                    result[j]=j*2-1;
                }
            }
        }
        System.out.println("yes");
    }
}
