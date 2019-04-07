package 编程题.笔试题.腾讯.打怪兽;

/**
 * @author LIFAN
 * 2019/4/5 22:08
 */

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] f = new int[n];
            int[] v = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                v[i] = scanner.nextInt();
            }
            int cost = v[0];
            long leval = f[0];
            for (int i = 1; i < n; i++) {
                if (f[i] >= leval) {
                    cost += (long) v[i];
                    leval += f[i];
                }
            }
            System.out.println(cost);
        }
    }
}