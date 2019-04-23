package 编程题;

import java.util.Scanner;

/**
 * @author LIFAN
 * 2019/4/14 11:16
 */
public class Main {


    public static void solve(int n,int[] color,int[] root) {



    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] root = new int[n];
        root[0] = 0;
        int[] color = new int[n];
        for(int i=1;i<n;i++) {
            root[i] = in.nextInt();
        }

        for(int i=0;i<n;i++){
            color[i] = in.nextInt();
        }


        //int result = solve(n,color,root);
        //System.out.println(result);

    }
}

//4
//        0 2 6 5
//        2 0 4 4
//        6 4 0 2
//        5 4 2 0