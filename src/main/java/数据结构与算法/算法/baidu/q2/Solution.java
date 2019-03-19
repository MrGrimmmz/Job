package 数据结构与算法.算法.baidu.q2;

/**
 * FileName: Cake
 * Author:   ifcc
 * School:   Southeast University
 * Date:     2018/9/26 20:01
 * Description:
 */
public class Solution {
    public int minGasStation(int numOfGS, int[] distOfGS,
                             int[] allowedGasoline, int distance,
                             int initialGasoline)
    {
        // WRITE YOUR CODE HERE
        int result=0,count=initialGasoline;
        for(int i=0;i<numOfGS;i++)
        {

            if (count<distOfGS[i]){
                return -1;
            }
            if (i==numOfGS-1){
                if (count<distance){
                    if (count+allowedGasoline[i]<distance){
                        return -1;
                    }else {
                        return result+1;
                    }
                }else {
                    return result;
                }
            }
            if(count<distOfGS[i+1])
            {
                result++;
                count+=allowedGasoline[i];
            }
        }
        return result;
    }
}
