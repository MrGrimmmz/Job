package 数据结构与算法.算法.fx;

import java.util.Scanner;

/**
 * FileName: Question1
 * Author:   ifcc
 * School:   Southeast University
 * Date:     2018/7/1 19:30
 * Description:
 */
public class Question1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String string1 = "1080::8:800:200C:417a";
        //System.out.println('f'-0);
        String result = solution(string1);
        System.out.println(result);

    }
    private static String solution(String str){
        String[] strArray = str.split(":");
        String result="";
        int flag=0;
        for(int i=0;i<strArray.length;i++){
            for (int j=0;j<strArray[i].length();j++){
                char c=strArray[i].charAt(j);
                if ((c-0>=48&&c-0<=57)||(c-0>=97&&c-0<=102)||(c-0>=65&&c-0<=70)){

                }else{
                    return "Error";
                }
            }
            int len=4-strArray[i].length();
            if (len==1){
                strArray[i]="0"+strArray[i];
            }else if(len==2){
                strArray[i]="00"+strArray[i];
            }else if(len==3){
                strArray[i]="000"+strArray[i];
            }else if(len==4){
                if (flag>0){
                    return "Error";
                }
                flag++;
                strArray[i]="0000";
                for(int j=0;j<8-strArray.length;j++){
                    strArray[i]+=":0000";
                }
            }

        }
        result=strArray[0];
        for (int i=1;i<strArray.length;i++){
            result+=":"+strArray[i];
        }
        return result;
    }

}
