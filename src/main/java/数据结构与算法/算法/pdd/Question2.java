package 数据结构与算法.算法.pdd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * FileName: Question2
 * Author:   ifcc
 * School:   Southeast University
 * Date:     2018/7/22 19:56
 * Description:
 */
public class Question2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().trim().split(" ");
        int [] nums=new int[strings.length];
        for (int i=0;i<strings.length;i++){
            nums[i]=Integer.parseInt(strings[i]);
        }
        Arrays.sort(nums);System.out.println(Arrays.toString(nums));
        int result=0;
        int i=0,j=nums.length-1;
        while (i<=j){
            if (i!=j&&(nums[j]>200 || (nums[j]+nums[i])>300) ){
                j--;
                result++;
            }else if (i!=j && (nums[j]+nums[i])>200 && (nums[j]+nums[i])<=300){
                j--;
                i++;
                result++;
            }else if (nums[j]==100){
                int s=100;
                result++;
                j--;
                while (j>=i && s<300){
                    s+=100;
                    j--;
                }
            }else  if (i==j){
                result++;
                j--;
            }
        }

        System.out.println(result);
    }

}
