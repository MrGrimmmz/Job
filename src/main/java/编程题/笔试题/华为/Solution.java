package 编程题.笔试题.华为;
import java.util.*;
/**
 * @author LIFAN
 * 2019/4/4 12:57
 */

public class Solution {

    public static String leftMove(String str, int num) {
        num %= str.length();
        StringBuilder sb = new StringBuilder();
        for(int i=num;i<str.length();i++){
            sb.append(str.charAt(i));
        }
        for(int i=0;i<num;i++){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> strList = new ArrayList<String>(100);

        while(true){
            String str = scan.nextLine();
            if (str.equals("")) {
                break;
            }
            strList.add(str);
        }

        HashSet<String> corrStrSet = new HashSet<String>();
        List<String> corrStrList = new ArrayList<String>();
        List<String> falseStrList = new ArrayList<String>();
        for (String str : strList) {
            //判断是否合法
            boolean flag = true;
            char[] charArray = str.toCharArray();
            for(int i=0;i<charArray.length;i++){
                if(!((charArray[i]>='0' && charArray[i]<='9') || (charArray[i]>='a' && charArray[i]<='z') || (charArray[i]>='A' && charArray[i]<='Z'))){
                    flag = false;
                    break;
                }
                //System.out.println(charArray[i]);
            }
            if(flag == true){
                if(corrStrSet.add(str)){
                    corrStrList.add(str);
                }
            }else{
                falseStrList.add(str);
            }
        }

        //合法字符串
        for(String str : corrStrList){
            System.out.print(str);
            System.out.print(" ");

        }
        //System.out.println();

        //非法字符串
        for(String str : falseStrList){
            System.out.print(str);
            System.out.print(" ");
        }

        //System.out.println();
        List<String> leftMoveList = new ArrayList<String>();
        for(String str : corrStrSet){
            leftMoveList.add(leftMove(str,10));
        }

        //左移
        for(String str : leftMoveList){
            System.out.print(str);
            System.out.print(" ");

        }
        //System.out.println();

        //排序
        Collections.sort(leftMoveList);
        for(String str : leftMoveList){
            System.out.print(str);
            System.out.print(" ");
        }
    }

//    abc
//            def
//==
//    acd123
//44234tjg
//    aga'-=
//    ad--s
//            abd
//123
//    abcdef
//123456789012345678901234567890123456789012345678901234567890123
//    EDFG
//            SDFG
//    ABC
//            DEF
//    cccc
//    a*b=1
//    abc
//            cccc
//    dd
//            def
//87&&^
//    abc
//            asdfas
//234abc35
//765rgfh4sd
//1231
//        123
//        ==
//    EDFG
}


