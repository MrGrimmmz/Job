package Java基础.集合.最小乘积和;

/**
 * @author LIFAN
 * 2019/3/10 17:37
 */
import java.util.Arrays;
import java.util.Scanner;

public class zuixiaochengjihe{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //判断是否满足条件
        if(n < 0){
            return;
        }
        long result = 0;
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0;i<n;i++){
            a[i] = scanner.nextInt();
        }
        for(int i=0;i<n;i++){
            b[i] = scanner.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);
        for(int i=0;i<n;i++){
            result = result + a[i] * b[n-1-i];
        }
        System.out.println(result);
    }
}
