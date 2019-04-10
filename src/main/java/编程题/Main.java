package 编程题;

import java.util.Scanner;

/**
 * @author LIFAN
 * 2019/3/12 15:09
 */
public class Main {

    public static String Calulate(String str){

        return new String("123");

    }


    public static void main (String[]args){

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        //String str = "ab2{AB}";
        String res = Calulate(str);

        System.out.println(res);
    }

}


