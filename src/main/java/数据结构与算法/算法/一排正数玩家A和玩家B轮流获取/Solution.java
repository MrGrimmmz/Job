package 数据结构与算法.算法.一排正数玩家A和玩家B轮流获取;



import java.util.Random;

/**
 * 有一排正数，玩家A和玩家B都可以看到。
 每位玩家在拿走数字的时候，都只能从最左和最右的数中选择一个。
 玩家A先拿，玩家B再拿，两人交替拿走所有的数字，
 两人都力争自己拿到的数的总和比对方多。请返回最后获胜者的分数。
 例如：
 5,2,3,4
 玩家A先拿，当前他只能拿走5或者4。
 如果玩家A拿走5，那么剩下2，3，4。轮到玩家B，此时玩家B可以选择2或4中的一个，…
 如果玩家A拿走4，那么剩下5，2，3。轮到玩家B，此时玩家B可以选择5或3中的一个，…
 * @Author ifcc
 * @Date 2018-05-07
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){
        int testTime=50000;
        boolean err=false;
        for (int i=0;i<testTime;i++){
            int[] array=generatorRandomArray();
            int r1=solution1(array);
            int r2=solution1(array);
            int r3=solution1(array);
            int r4=solution1(array);
            if (r1!=r2||r1!=r3||r1!=r4){
                err=true;
            }
        }
        if (err){
            System.out.println("2333333333333");
        }else {
            System.out.println("6666666666666");
        }
    }

    private static int[] generatorRandomArray() {
        Random random = new Random();
        int n = random.nextInt(20) + 1;
        int[] array = new int[n];
        for (int i=0;i<array.length;i++){
            array[i]=random.nextInt(20)+1;
        }
        return  array;
    }

    /**
     * 方法一：递归方法
     * @param array
     * @return
     */
    public static int solution1(int[] array){
        if (array==null||array.length==0){
            return 0;
        }
        return Math.max(f(array,0,array.length-1),s(array,0,array.length-1));
    }
    public static int f(int[] array,int i,int j){
        if (i==j){
            return array[i];
        }
        return Math.max(array[i]+s(array,i+1,j),array[j]+s(array,i,j-1));
    }

    private static int s(int[] array, int i, int j) {
        if (i==j){
            return 0;
        }
        return Math.min(f(array,i+1,j),f(array,i,j-1));
    }

    /**
     * 方法二：方法一的动态规划方案
     * @param array
     * @return
     */
    public static int solution2(int[] array){
        if (array==null||array.length==0){
            return 0;
        }
        int[][] f=new int[array.length][array.length];
        int[][] s=new int[array.length][array.length];
        for (int j=0;j<array.length;j++){
            f[j][j]=array[j];
            for (int i=j-1;i>=0;i--){
                f[i][j]=Math.max(array[i]+s[i+1][j],array[j]+s[i][j-1]);
                s[i][j]=Math.min(f[i+1][j],f[i][j-1]);
            }
        }
        return Math.max(f[0][array.length-1],s[0][array.length-1]);
    }

    /**
     * 方法三：只计算先发者，即将方法一的s()带入到f()中
     * @param array
     * @return
     */
    public static int solution3(int[] array){
        int sum=0;
        for (int i=0;i<array.length;i++){
            sum+=array[i];
        }
        int scores=p(array,0,array.length-1);
        return Math.max(sum-scores,scores);
    }

    public static int p(int[] array,int i,int j){
        if (i==j){
            return array[i];
        }
        if (i+1==j){
            return Math.max(array[i],array[j]);
        }
        return Math.max(
               array[i]+Math.min(p(array,i+2,j),p(array,i+1,j-1)),
               array[j]+Math.min(p(array,i+1,j-1),p(array,i,j-2))
        );
    }

    /**
     * 方法四：方法三的动态规划方案
     * @param array
     * @return
     */
    public static int solution4(int[] array){
        if (array==null||array.length==0){
            return 0;
        }
        int[][] p=new int[array.length][array.length];
        for (int j=0;j<array.length;j++){
            p[j][j]=array[j];
            if (j>0){
                p[j-1][j]=Math.max(array[j-1],array[j]);
            }
            for (int i=j-2;i>=0;i--){
                p[i][j]=Math.max(array[i]+Math.min(p[i+2][j],p[i+1][j-1]),array[j]+Math.min(p[i+1][j-1],p[i][j-2]));
            }
        }
        int sum=0;
        for (int i=0;i<array.length;i++){
            sum+=array[i];
        }
        return Math.max(p[0][array.length-1],sum-p[0][array.length-1]);
    }


}
