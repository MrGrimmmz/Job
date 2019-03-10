package Java基础.集合.硬币;

import java.util.Scanner;

/**
 * @author LIFAN
 * 2019/3/9 19:38
 */
public class niuniu {
    public static int result=0;

    public static int Calculate(int n,int m){
        if(n >= m){
            result = 1;
        }else{
            result = m/n + 1;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        if(n < 1 || m < 1){
            return;
        }else{
            System.out.println(Calculate(n,m));
        }
    }
}
