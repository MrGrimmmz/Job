package 编程题.动态规划;

/**
 * @author LIFAN
 * 2019/3/18 20:05
 * 求斐波拉契数列Fibonacci
 * 自底向上
 */
public class Fibonacci {
    //循环
    public static int fib(int n)
    {
        if(n<=1)
            return n;

        int cur_pre_pre = 0;
        int cur_pre = 1;
        int cur = 1;
        for(int i=2;i<=n;i++)
        {
            cur = cur_pre_pre + cur_pre;
            cur_pre_pre = cur_pre;
            cur_pre = cur;
        }
        return cur;
    }


    //递归
    public static int fibDigui(int n)
    {
        if(n<=1){
            return n;
        }else{
            return fibDigui(n-1) + fibDigui(n-2);
        }
    }

    public static void main(String[] args){
        int n = 6;
        System.out.println(fib(n));
        System.out.println(fibDigui(n));
    }
}