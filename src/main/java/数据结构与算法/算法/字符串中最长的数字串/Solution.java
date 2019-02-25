package 数据结构与算法.算法.字符串中最长的数字串;

import java.util.Scanner;

/**
 *   写一个函数,它的原形是int continumax(char *outputstr,char *intputstr)
 功能：在字符串中找出连续最长的数字串，并把这个串的长度返回，
 并把这个最长数字串付给其中一个函数参数outputstr所指内存。
 例如："abcd12345ed125ss123456789"的首地址传给intputstr后，函数将返回9，
 outputstr所指的值为123456789
 * @Author ifcc
 * @Date 2018-04-25
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String result = solution(s);
        System.out.println(result);
    }
    public static String solution(String s){
        String result="";
        StringBuilder temp=new StringBuilder();
        for (int i=0;i<s.length();i++){
            if ((s.charAt(i)-'0')>=0&&(s.charAt(i)-'0')<=9){
                temp.append(s.charAt(i));
            }else {
                if(temp.length() > result.length()){
                    result=temp.toString();
                }
                temp.delete(0,temp.length());
            }
        }
        if(temp.length() > result.length()){
            result=temp.toString();
        }
        return result;
    }
}
