package 编程题.腾讯.奇妙的数列;

import java.util.Scanner;

/**
 * @author LIFAN
 * 2019/3/9 20:14
 */
public class shulie {
    public static int[] Calculate(int q,int[] l,int[] r){
        int[] result = new int[q];
        for(int i = 0;i<q;i++){
            if(l[i] == r[i]){
                result[i] = (l[i]%2 == 0)? l[i] : (0-r[i]);
            }else{
                if(l[i]%2 != 0){
                    if(r[i]%2 == 0){
                        result[i] = (r[i] - l[i])/2 + 1;
                    }else{
                        result[i] = (r[i] - 1 - l[i])/2 + 1 - r[i];
                    }
                }else{
                    if(r[i]%2 == 0){
                        result[i] = 0 - ((r[i]- 1 - l[i])/2 + 1) + r[i];
                    }else{
                        result[i] = 0 - ((r[i] - l[i])/2 + 1);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        int[] l = new int[q];
        int[] r = new int[q];

        for(int i=0;i<q;i++){
            l[i] = scan.nextInt();
            r[i] = scan.nextInt();
        }

        int[] res = Calculate(q,l,r);
        for(int i=0;i<q;i++){
            System.out.println(res[i]);
        }


    }
}
