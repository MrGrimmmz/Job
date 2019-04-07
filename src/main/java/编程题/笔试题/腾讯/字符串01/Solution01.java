package 编程题;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author LIFAN
 * 2019/3/12 15:09
 */
public class Solution01 {
    public static int Calculate(String str,int n){
//        char[] charArray = new char[n];
//        charArray = str.toCharArray();
        Stack<String> stack = new Stack<String>();
        for(int i = 0;i<n;i++){
            if(stack.empty() || stack.peek().equals(str.substring(i,i+1))){
                stack.push(str.substring(i,i+1));
            }else{
                stack.pop();
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String str = scan.next();
//        int n = 5;
//        String str = "10101";
        int res = Calculate(str,n);
        System.out.print(res);
    }

}

