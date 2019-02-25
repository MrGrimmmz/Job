package 数据结构与算法.算法.pdd;import java.util.Arrays;
import java.util.Scanner;

public class mm {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String w="100 140 100 100 100 200";
        String[] s = sc.nextLine().split(" ");
        int length = s.length;
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            temp[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(temp);
        int count = 0;
        int i = length - 1;
        for (; i >= 0; i--) {
            if (temp[i] == 300) {
                count++;

            } else {
                break;
            }
        }
        int k = 0, y = 0;
        for (; k <= i; k++) {
            if (temp[k] == 100) {
                y++;
            } else {
                break;
            }
        }
        count = count + k / 3;
        int j = k / 3 * 3;
        for (; i >= j; ) {
            if (temp[i] + temp[j] <= 300) {
                i--;
                j++;
                count++;
                continue;
            }
            if (temp[i] + temp[j] > 300) {
                i--;
                count++;
                continue;
            }
        }
        System.out.println(count);
    }
}