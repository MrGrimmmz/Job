package 数据结构与算法.算法.fx;

import java.util.HashMap;
import java.util.Scanner;

/**
 * FileName: Question2
 * Author:   ifcc
 * School:   Southeast University
 * Date:     2018/7/1 20:15
 * Description:
 */
public class Question2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String json="";
        String temp="";
        while ((temp=scanner.nextLine()).length()>0){
            json+=temp;
        }
        String question=scanner.nextLine();
        //System.out.println(json);
        //System.out.println(json.substring(1,json.length()-1));
        Object result = solution(json, question);
        System.out.println(result);
    }
    public static Object solution(String json,String question){
        //HashMap<String, Object> map = new HashMap<String, Object>();
        json=json.substring(1,json.length()-1);
        String[] jsonArray = json.split(",");
        for (int i=0;i<jsonArray.length;i++){
            String[] keyValueArr = jsonArray[i].split(":");
            if (keyValueArr[0].equals("\""+question+"\"")){
                return keyValueArr[1].substring(1,keyValueArr[1].length()-1);
            }
        }
        return "";
    }

}
