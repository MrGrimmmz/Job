package 数据结构与算法.算法.Ali.面试题2;

import jdk.nashorn.internal.runtime.FindProperty;

import java.util.Scanner;

/**
 * FileName: Solution3
 * Author:   ifcc
 * School:   Southeast University
 * Date:     2018/9/7 19:51
 * Description:
 */
public class Solution3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] pointString = scanner.nextLine().trim().split(",");
        Point destination = new Point(Integer.valueOf(pointString[0]), Integer.valueOf(pointString[1]));
        pointString = scanner.nextLine().trim().split(",");
        Point[] location=new Point[pointString.length/2];
        for (int i=0;i<pointString.length;i=i+2){
            Point point = new Point(Integer.valueOf(pointString[i]), Integer.valueOf(pointString[i + 1]));
            location[i/2]=point;
        }
        boolean result=true;
        for (int i=0;i<location.length;i++){
            int j=i+1;
            if (i==location.length-1){
                j=0;
            }
            boolean temp = check(destination, location[i], location[j]);
            if (temp==false){
                result=false;
            }
        }
        if (result){
            System.out.println("yes,0");
            return;
        }
        int shortInstance=Integer.MAX_VALUE;
        for (int i=0;i<location.length;i++){
            int j=i+1;
            if (i==location.length-1){
                j=0;
            }
            if ((destination.x>=location[i].x&&destination.x<=location[j].x)||(destination.x<=location[i].x&&destination.x>=location[j].x)){
                int temp=Math.abs(destination.y-location[i].y);
                if (temp<shortInstance){
                    shortInstance=temp;
                }
            }else if ((destination.y>=location[i].y&&destination.y<=location[j].y)||(destination.y<=location[i].y&&destination.y>=location[j].y)){
                int temp=Math.abs(destination.x-location[i].x);
                if (temp<shortInstance){
                    shortInstance=temp;
                }
            }
        }
        if (shortInstance!=Integer.MAX_VALUE){
            System.out.println("no,"+shortInstance);
            return;
        }
        for (int i=0;i<location.length;i++){
            int temp = (int) Math.round(Math.sqrt(Math.pow(location[i].x - destination.x, 2) + Math.pow(location[i].y - destination.y, 2)));
            if (temp<shortInstance){
                shortInstance=temp;
            }
        }
        System.out.println("no,"+shortInstance);
    }

    public static boolean check(Point destination,Point pointA,Point pointB){
        return (destination.y-pointA.y)*(destination.x-pointB.x)-(destination.y-pointB.y)*(destination.x-pointA.x)>=0;
    }

    private static class Point{
        int x;
        int y;
        public Point(int x,int y){
            this.x=x;
            this.y=y;
        }
        public Point(){}

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
