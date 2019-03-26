//package 数据结构与算法.算法.ctrip.q2;
//
//import java.util.Map;
//import java.util.LinkedList;
//import java.util.Scanner;
//
///**
// * FileName: Cake
// * Author:   ifcc
// * School:   Southeast University
// * Date:     2018/9/4 19:47
// * Description:
// */
//public class Cake {
//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        int n = Integer.valueOf(scanner.nextLine().trim());
//        LinkedList<Integer> list=new LinkedList<>();
//        Map<Integer, Integer> map = new Map<>();
//        while (scanner.hasNext()){
//            String s = scanner.nextLine().trim();
//            String[] stringArray = s.split(" ");
//            if ("p".equalsIgnoreCase(stringArray[0])){
//                if (map.containsKey(Integer.valueOf(stringArray[1]))){
//                    map.put(Integer.valueOf(stringArray[1]),Integer.valueOf(stringArray[2]));
//                }else {
//                    if (map.size()>=n){
//                        Integer last = list.poll();
//                        map.remove(last);
//                        list.add(Integer.valueOf(stringArray[1]));
//                        map.put(Integer.valueOf(stringArray[1]),Integer.valueOf(stringArray[2]));
//                    }else {
//                        list.add(Integer.valueOf(stringArray[1]));
//                        map.put(Integer.valueOf(stringArray[1]),Integer.valueOf(stringArray[2]));
//                    }
//                }
//            }else if ("g".equalsIgnoreCase(stringArray[0])){
//                Integer value = map.get(Integer.valueOf(stringArray[1]));
//                if (value!=null){
//                    list.remove(Integer.valueOf(stringArray[1]));
//                    list.add(Integer.valueOf(stringArray[1]));
//                }
//                System.out.println(value);
//            }
//
//        }
//    }
//}
