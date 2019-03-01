package 编程题.剑指offer.二维数组查找;

/**
 * @author LIFAN
 * 2019/3/1 18:25
 */
//二维数组中的查找

//在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
//请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
public class Solution {
    public static boolean Find(int target, int [][] array) {
        boolean found = false;
        if(array != null){
            int row = 0;
            int rows = array.length;
            int columns = array[0].length;
            int column = columns - 1;
            while(row < rows && column >= 0){
                if(array[row][column] == target){
                    found = true;
                    break;
                }else if(array[row][column] < target){
                    row++;
                }else{
                    column--;
                }
            }

        }
        return found;
    }
    public static void main(String[] args){
        int[][] arr = {{1,2},{3,4},{4,6}};
        boolean result = Find(5,arr);
        System.out.println(result);
    }
}
