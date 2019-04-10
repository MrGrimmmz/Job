package 编程题.笔试题.招行信用卡.倒水;

/**
 * @author LIFAN
 * 2019/4/9 20:33
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int[] cups = new int[n*2];
        for (int i=0;i<n*2;i++){
            cups[i]=scanner.nextInt();
        }
        Arrays.sort(cups);
        double result;
        if (cups[n]>cups[0]*2){
            result=1.000000*cups[0]*(n)*3;
        }else{
            result=1.000000*cups[n]*(n)*1.5;
        }
        if (result>l){
            result=l;
        }
        System.out.println(String.format("%.6f",result));
    }
}