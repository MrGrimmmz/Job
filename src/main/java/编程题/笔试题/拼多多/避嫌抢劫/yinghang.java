package 编程题.笔试题.拼多多.避嫌抢劫;

/**
 * @author LIFAN
 * 2019/3/10 17:46
 */
import java.util.Scanner;

public class yinghang {
    static class Bank{
        int location;
        int money;
        Bank(int location,int money){
            this.location=location;
            this.money=money;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int d=scanner.nextInt();
        Bank[] banks=new Bank[n];
        for (int i=0;i<n;i++){
            int location=scanner.nextInt();
            int money=scanner.nextInt();
            banks[i]=new Bank(location,money);
        }
        int result=0;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if (Math.abs(banks[j].location-banks[i].location)>=d){
                    if (result<(banks[j].money+banks[i].money)){
                        result=banks[j].money+banks[i].money;
                    }
                }
            }
        }
        System.out.println(result);
    }

}
