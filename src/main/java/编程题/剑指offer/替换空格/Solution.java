package 编程题.剑指offer.替换空格;

/**
 * @author LIFAN
 * 2019/3/1 19:49
 */
public class Solution {
    public static String replaceSpace(StringBuffer str) {
        int originalLen = str.length();
        int numOfBlank = 0;
        int i = 0;
        //求空格的数量和数组长度
        for(i=0;i<originalLen;i++){
            if(str.charAt(i) == ' '){
                numOfBlank++;
            }
        }
        //求替换后的数组长度
        int newLen = originalLen + numOfBlank * 2;
        str.setLength(newLen);

        //定义两个指针对应替换后数组尾部和原数组尾部
        int indexOfOriginal = originalLen - 1;
        int indexOfNew = newLen - 1;
        while(indexOfOriginal >= 0 && indexOfNew > indexOfOriginal){
            if(str.charAt(indexOfOriginal) == ' '){
                str.setCharAt(indexOfNew--, '0');
                str.setCharAt(indexOfNew--, '2');
                str.setCharAt(indexOfNew--, '%');
            }else{
                str.setCharAt(indexOfNew--, str.charAt(indexOfOriginal));
            }
            indexOfOriginal--;
        }
        return str.toString();
    }

    public static void main(String[] args){
        StringBuffer buff = new StringBuffer("I am LIFAN");
        String buff1 = replaceSpace(buff);
        System.out.println(buff1);
    }
}
