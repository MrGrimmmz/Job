package 数据结构与算法.算法.高级字符串的匹配;

import sun.awt.image.OffScreenImage;

import java.util.BitSet;
import java.util.Scanner;

/**
 *  实现一个挺高级的字符匹配算法：
 给一串很长字符串，要求找到符合要求的字符串，例如目的串：123
 1******3***2 ,12*****3这些都要找出来
 其实就是类似一些和谐系统。。。。。
 * @Author ifcc
 * @Date 2018-05-03
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String source = scanner.next();
        String goal = scanner.next();
        solution(source,goal);
    }
    public static void solution(String source,String goal){
        BitSet bitSet = new BitSet(256);
        char[] sourceChars = source.toCharArray();
        char[] goalChars = goal.toCharArray();
        boolean flag=true;
        for (int i=0;i<sourceChars.length;i++){
            bitSet.set(sourceChars[i],true);
        }
        for (int i=0;i<goalChars.length;i++){
            if (!bitSet.get(goalChars[i])){
                flag=false;
                break;
            }
        }
        if (flag){
            System.out.println("match");
        }else{
            System.out.println("dismatch");
        }
    }
}
