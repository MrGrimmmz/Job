package 数据结构与算法.算法.Ali.面试题2;

import java.util.Scanner;

/**
 * FileName: Cake
 * Author:   ifcc
 * School:   Southeast University
 * Date:     2018/8/1 22:31
 * Description:
 */
public class Solution {
    static final Point START = new Point(0,0);
    static int minPath = Integer.MAX_VALUE;

    public static int solution(Point start, Point[] points, int sum, int count){
        if(count == points.length){
            minPath = Math.min(minPath, sum +start.getLength(START));
            return minPath;
        }
        for(int i = 0; i<points.length; i++){
            if(points[i].visited == false){
                sum += points[i].getLength(start);
                if(sum < minPath){
                    points[i].visited = true;
                    solution(points[i], points, sum, count+1);
                }
                sum -= points[i].getLength(start);
                points[i].visited = false;
            }
        }
        return minPath;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int pointNum = Integer.parseInt(input.nextLine().trim());

        Point[] points = new Point[pointNum];
        for(int i = 0; i<pointNum; i++){
            String[] locations = input.nextLine().trim().split(",");
            points[i] = new Point(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
        }
        int result = solution(START, points, 0, 0);
        System.out.println(result);
    }
}

class Point{
    int px;
    int py;
    boolean visited;

    public Point(int px, int py) {
        this.px = px;
        this.py = py;
        this.visited = false;
    }

    public int getLength(Point p){
        return Math.abs(px - p.px) + Math.abs(py - p.py);
    }
}