package 编程题;

import java.util.Scanner;

/**
 * @author LIFAN
 * 2019/4/14 11:16
 */
/*
 * 贪心算法求解TSP问题
 * 按照贪心算法的思想每次选取距离当前城市距离最近的城市，直到所有城市选取完毕
 */
public class Main {

    public static int solve(int[][] distance,int citynumbers) {
        int[] path;
        int[] visited;//确定是否访问过
        int s = 0;
        visited=new int[citynumbers];//确定是否访问过
        path=new int[citynumbers];
        for(int i=0;i<citynumbers;i++) {
            visited[i]=0;//0代表未被访问过，1代表访问过
        }
        path[0]=1;//从城市1开始
        visited[0]=1;//城市1访问置1
        int k=0; //k代表当前的城市,0代表城市1
        int next=k+1;//next表示下一个访问城市，每次开始先确定为k+1
        int min=Integer.MAX_VALUE;//min代表最小距离，设置为这个数，必然会被更新
        int count=1;//计数
        while( count<citynumbers) {
            for(int j=0;j<citynumbers;j++) {
                if(visited[j]==0) {//未被访问
                    if(distance[k][j]<min) {//找到更小的距离值，则更新距离最小值
                        min=distance[k][j];
                        next=j;
                    }
                }
            }
            s=s+min;//累加距离
            path[count]=next+1;//存放找到下一个城市
            visited[next]=1;//置访问标记为1
            k=next;//更新当前城市
            count++;
            min=Integer.MAX_VALUE;//更新最小值
            next=k+1;
        }
        return s;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] distance = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                distance[i][j]=in.nextInt();
            }
        }
        int result = solve(distance,n);
        System.out.println(result);

    }
}

//4
//        0 2 6 5
//        2 0 4 4
//        6 4 0 2
//        5 4 2 0