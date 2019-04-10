package 编程题.笔试题.招行信用卡.巧克力;

/**
 * @author LIFAN
 * 2019/4/9 20:19
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long result = 0;
        if(n >= 6){
            result = solute(n);
        }
        System.out.println(result);
        //System.out.println(solute(5));
    }

    public static long solute(int n) {
        long res = 1;
        for(int i = 0;i<n-6;i++){
            res *= 2;
        }
        return res;
    }
}