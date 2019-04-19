package 编程题.笔试题.华为.翻转字符串;

/**
 * @author LIFAN
 * 2019/4/15 13:46
 */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //String str = in.next();
        String str = "abc3(2[sd]3{s}A2(d))";
        System.out.println(matchStr(str));

    }

    public static String matchStr(String str) {
        ArrayList<Character> arr=new ArrayList<Character>();
        StringBuilder sb;
        int index=0;
        boolean flag=true;
        while(flag) {
            index=0;
            flag=false;
            sb=new StringBuilder();
            //首先将外围括号全部去掉,由外到内
            while(index<str.length()) {
                //是否是数字
                if (str.substring(index, index+1).matches("\\d")) {
                    flag=true;
                    int start=index;
                    index++;
                    Stack<Character> st=new Stack<Character>();
                    st.add(str.charAt(index++));
                    while(!st.isEmpty()) {
                        if (str.charAt(index)==st.peek()) {
                            st.push(str.charAt(index));

                        }
                        //左右小括号相差1，左右中括号和大括号相差2
                        else if (str.charAt(index)==st.peek()+1||
                                str.charAt(index)==st.peek()+2) {
                            st.pop();
                        }
                        index++;
                    }
                    for (int i = 0; i < Integer.parseInt(str.substring(start, start+1)); i++) {
                        sb.append(str.substring(start+2,index-1));
                    }
                } else {
                    sb.append(str.charAt(index));
                    index++;
                }
            }
            str=sb.toString();
        }

        StringBuilder s = new StringBuilder();
        s.append(str);
        s.reverse();

        return s.toString();
    }
}
