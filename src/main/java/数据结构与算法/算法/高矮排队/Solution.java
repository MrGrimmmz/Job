package 数据结构与算法.算法.高矮排队;

/**阿里巴巴笔试题
 *  问题描述:
 12个高矮不同的人,排成两排,每排必须是从矮到高排列,而且第二排比对应的第一排的人高,问排列方式有多少种?
 这个笔试题,很YD,因为把某个递归关系隐藏得很深。
 * @Author ifcc
 * @Date 2018-04-28
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){
       /* int result = solution();
        System.out.println(result);*/
       DG(0,0,"");
       System.out.println(count);
    }
    public static int solution(){
        int[] F=new int[6];//第一排
        int[] B=new int[6];//第二排
        int count=0,state,i,j,k,ok=0;
        for (state=0;state<(1<<12);state++){
            if (bit_cnt(state)==6){
                i=j=0;
                for (k=0;k<12;k++){
                    if ((state&(1<<k))!=0){
                        B[i++]=k;
                    }else {
                        F[j++]=k;
                    }
                }
                ok=1;
                for (k=0;k<6;k++){
                    if (F[k]>B[k]){
                        ok=0;
                        break;
                    }
                }
                count+=ok;
            }
        }
        return count;
    }
    public static int bit_cnt(int n){
        int result=0;
        while (n!=0){
            n&=n-1;
            result++;
        }
        return result;
    }

    public static int count=0;
    //递归方式
    public static void DG(int count_0,int count_1,String str){
        if (count_0==6&&count_1==6){
            count++;
            System.out.println(str);
            return;
        }
        if (count_0<6){
            DG(count_0+1,count_1,str+"{");
        }
        if (count_0>count_1){
            DG(count_0,count_1+1,str+"}");
        }


    }


}
