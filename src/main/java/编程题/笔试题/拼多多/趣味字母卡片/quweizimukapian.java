package 编程题.笔试题.拼多多.趣味字母卡片;

/**
 * @author LIFAN
 * 2019/3/10 17:12
 */
import java.util.Scanner;

/**
 * @Author ifcc
 * @Date 2019-03-10
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class quweizimukapian {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next().toLowerCase();
        char[] charArray = str.toCharArray();
        int[] cishu = cishu(charArray);
        for(int i=0;i<cishu.length;i++){
            System.out.println(cishu[i]);
        }
        int index = 0;
        for (int i=0;i<charArray.length;i++){
            if (cishu[i] == 1){
                if (charArray[index]>charArray[i]){
                    index = i;
                    continue;
                }
            }else {
                System.out.println(charArray[i]>charArray[index]?charArray[index]:charArray[i]);
                return;
            }
        }
    }

    private static int[] cishu(char[] charArray){
        int[] cishu = new int[charArray.length];
        for (int i=0;i<charArray.length;i++){
            for (int j=i+1;j<charArray.length;j++){
                if (charArray[i] == charArray[j]){
                    cishu[i] = 1;
                    break;
                }
            }
        }
        return cishu;
    }
}
