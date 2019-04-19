package 编程题.笔试题.华为.翻转字符串;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author LIFAN
 * 2019/3/12 15:09
 */
public class Solution {

    public static String Calulate(String str){
        Stack<Character> stack1 = new Stack<Character>();
        Stack<Character> stack2 = new Stack<Character>();
        char[] charArray = str.toCharArray();
        for(int i=0;i<charArray.length;i++){
            //先将字母和数字存入字母数字栈
            if(Character.isLetterOrDigit(charArray[i])){
                stack1.push(charArray[i]);
            }else{
                //找到左括号，存入括号栈
                if(charArray[i] == '(' || charArray[i] == '[' || charArray[i] == '{' ){
                    stack2.push(charArray[i]);
                }else{
                    //找到右括号，计算重复字符串
                    //stack2.pop();
                    StringBuilder repeatStr = new StringBuilder();

                    //找出需要重复的字符串
                    while(Character.isLetter(stack1.peek())){
                        repeatStr.append(stack1.pop());
                    }
                    repeatStr.reverse();

                    //取出重复次数
                    char repeatNum1 = stack1.pop();
                    int repeatNum = Integer.parseInt(String.valueOf(repeatNum1));

                    //计算重复后的字符串
                    StringBuilder addStr = new StringBuilder();
                    for(int j = 0;j<repeatNum;j++){
                        addStr.append(repeatStr);
                    }

                    //push入栈
                    String addStr1 = new String(addStr);
                    char[] charArr = addStr1.toCharArray();
                    for(int k=0;k<charArr.length;k++){
                        stack1.push(charArr[k]);
                    }
                }
            }
        }

        StringBuilder resultStr = new StringBuilder();
        while(!stack1.empty()){
            resultStr.append(stack1.pop());
        }

        return new String(resultStr);

    }


    public static void main (String[]args){

            //Scanner scanner = new Scanner(System.in);
           //String str = scanner.next();

            String str = "ab2{A2[s]}";
            String res = Calulate(str);

            System.out.println(res);
    }

}

