package 编程题;

import java.util.*;

/**
 * @author LIFAN
 * 2019/3/12 15:09
 */
public class Solution {

    public static void leftMove(String str, int num) {

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> strSet = new HashSet<String>();
        List<String> strList = new ArrayList<String>(100);

        while(true){
            String str = scan.nextLine();
            if (str.equals("")) {
                break;
            }
            strList.add(str);
        }

        strList.addAll(strSet);



        Iterator<String> iterator = strList.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
    }

}

