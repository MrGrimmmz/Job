package 编程题;

/**
 * @author LIFAN
 * 2019/4/3 19:52
 */
import java.util.Scanner;
public class zuoyi{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();  		//输入一行字符串
        String from = reChange(s);
        int index = 10;
        String first = reChange(from.substring(0, from.length() - index));
        System.out.println(first);
        String second = reChange(from.substring(from.length() - index));
        System.out.println(second);
        from = first + second;
        System.out.println(from);
    }

    public static String reChange(String from) {
        char[] froms = from.toCharArray();
        for (int i = 0; i < from.length() / 2; i++) {
            char temp = froms[i];
            froms[i] = froms[froms.length - 1 - i];
            froms[froms.length - 1 - i] = temp;
        }
        return String.valueOf(froms);
    }
}
