package 数据结构与算法.算法.baidu.q1;

/**
 * FileName: Solution
 * Author:   ifcc
 * School:   Southeast University
 * Date:     2018/9/26 19:54
 * Description:
 */
public class Solution {
    public int minNumberOfProjects(int num, int projCmptDec, int restDec,
                                   int[] errorScore)
    {
        int result=0;
        while (true){
            int i=0,max=errorScore[0];
            for (int j=1;j<num;j++){
                if (max<errorScore[j]){
                    max=errorScore[j];
                    i=j;
                }
            }
            if (max==0){
                break;
            }
            for (int j=0;j<num;j++){
                if (j==i){
                    errorScore[j]-=projCmptDec;
                }else {
                    errorScore[j]-=restDec;
                }
            }
            result++;
        }
        return result;
    }
}
