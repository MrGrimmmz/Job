package 编程题.笔试题;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author LIFAN
 * 2019/3/12 15:09
 */
public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String calculate(int m, int k) {
        int numOfM = calM(m);
        int yearOfM = 0;
        int sum = 0;
        int j = 1;
        while(sum < m){
            sum += calYear(j);
            j++;
        }
        yearOfM = j-1+2019;
       int numOfGetAword = calAword(m,k);
       return String.valueOf(numOfM) + "," + String.valueOf(yearOfM) + "," + String.valueOf(numOfGetAword);


    }

    public static int calM(int m){
        if(m == 1){
            return 2;
        }else if(m == 2){
            return 3;
        }else if(m == 3){
            return 4;
        }
        return calM(m-2)+calM(m-3);
    }

    public static int calYear(int m){
        if(m == 1){
            return 2;
        }else if(m == 2){
            return 3;
        }
        return calM(m-1)+calM(m-2);
    }

    public static int calAword(int m,int k){
        Map<Integer,Integer> allM = new HashMap<Integer, Integer>();
        int [] allM1 = new int[m];
        //获得所有数列
        for(int i=0;i<m;i++){
            int numOfM = calM(i+1);
            allM.put(reverse(numOfM),i+1);
            allM1[i] = reverse(numOfM);
        }

        Arrays.sort(allM1);

        //return allM.get(allM1[m-k]);
        return allM1[m-k];
    }

    //翻转数字
    static int reverse(int num) {
//        int rs = 0;
//        while (a > 0) {
//            rs *= 10;
//            rs += a % 10;
//            a /= 10;
//        }
//        return rs;
        int c = 0;
        while (num != 0) {
            int temp = c;   //临时记录c 用于判断是否溢出
            c = c * 10 + num % 10;
            num /= 10;
            if (c / 10 != temp) {  //如果c/10和临时记录并不相等，说明已经溢出了 结束循环
                c = 0;
                break;
            }
        }
        return c;

    }

    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        String[] line = in.nextLine().split(",");
//        int m = Integer.valueOf(line[0]);
//        int k = Integer.valueOf(line[1]);
//        int m=20;
//        int k =3;
//        System.out.println(calculate(m, k));
        //String str="";
        //System.out.println(str.split(",").length);

       Integer a=1;
        Integer b=1;
        Integer c=500;
        Integer d=500;
        System.out.println(a==b);
        System.out.println(c==d);
    }
}


