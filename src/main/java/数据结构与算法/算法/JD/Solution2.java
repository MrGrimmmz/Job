package 数据结构与算法.算法.JD;

        import java.util.Scanner;

/**
 * 题目描述：
 * 现有n个物品，每个物品有三个参数 ai , bi , ci ，定义i物品不合格品的依据是 : 若存在物品 j , 且aj>ai , bj>bi , cj>ci，则称i物品为不合格品。
 *
 * 现给出n个物品的a,b,c参数，请你求出不合格品的数量。
 * 第一行包含一个整数n(1<=n<=500000),表示物品的数量。接下来有n行，每行有三个整数，ai,bi,ci表示第i个物品的三个参数，1≤ai,bi,ci≤109。
 * 输出包含一个整数，表示不合格品的数量。
 * FileName: Solution2
 * Author:   ifcc
 * School:   Southeast University
 * Date:     2018/9/9 20:16
 * Description:
 */
public class Solution2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n=new Integer(scanner.nextLine().trim());
        Product[] products = new Product[n];
        for (int i=0;i<n;i++){
            String[] strings = scanner.nextLine().trim().split(" ");
            products[i]=new Product(Integer.valueOf(strings[0]),Integer.valueOf(strings[1]),Integer.valueOf(strings[2]));
        }
        int result=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if ((products[i].a<products[j].a)&&(products[i].b<products[j].b)&&(products[i].c<products[j].c)){
                    result++;
                    break;
                }
            }
        }
        System.out.println(result);
    }

    private static class Product{
        int a;
        int b;
        int c;
        public Product(int a,int b,int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
    }
}
