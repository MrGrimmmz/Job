package 书籍阅读总结.程序员代码面试指南.用栈来解决汉诺塔问题;

/**
 * 要求：
 * 限制不能从最左侧直接移动到最右侧，也不能从最右侧直接移动到最左侧，而是必须经过中间，求当塔有N层的时候，打印最优移动过程和总步数
 * @Author ifcc
 * @Date 2018-05-09
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    /**
     * 递归方法实现
     * @param num
     * @param left
     * @param mid
     * @param right
     * @return
     */
    public int solution1(int num,String left,String mid,String right){
        if (num<1){
            return 0;
        }
        return process(num,left,mid,right,left,right);
    }

    private int process(int num, String left, String mid, String right, String from, String to) {
           if (num==1){
               if (from.equals(mid)||to.equals(mid)){
                   System.out.println("Move 1 from "+from +" to "+to);
                   return 1;
               }else {
                   System.out.println("Move 1 from "+from+" to "+mid);
                   System.out.println("Move 1 from "+mid+" to "+to);
                   return 2;
               }
           }
           if (from.equals(mid)||to.equals(mid)){
               String another=(from.equals(left)||to.equals(left))?right:left;
               int part1=process(num-1,left,mid,right,from,another);
               int part2=1;
               System.out.println("Move "+ num +" from " + from + " to "+to);
               int part3=process(num-1,left,mid,right,another,to);
               return part1+part2+part3;
           }else {
               int part1=process(num-1,left,mid,right,from,to);
               int part2=1;
               System.out.println("Move "+num+" from "+from+" to "+mid);
               int part3=process(num-1,left,mid,right,to,from);
               int part4=1;
               System.out.println("Move "+num+" from "+mid+" to "+to);
               int part5=process(num-1,left,mid,right,from,to);
               return part1+part2+part3+part4+part5;
           }
    }
}
