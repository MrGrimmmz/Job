package 编程题.最长公共前缀;

/**
 * @author LIFAN
 * 2019/3/27 18:38
 */
public class longestCommonPrefix {
    //这道题的关键点，是前缀，如果是公共部分难度就大一些
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null|| strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        //假设，先取第一个字符串作为公共前缀
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {//从第二个元素开始遍历
            //通过while循环，选出第一个与遍历的每个N 字符串的公共部分
            while (strs[i].indexOf(prefix) != 0){//如果这个元素前缀不是prefix
                prefix = prefix.substring(0,prefix.length()-1);//删除最末尾的字符，缩小公共前缀，直到有公共开始的前缀部分

                if(prefix.isEmpty()){//在while循环过程，如果发现某个元素与第一个字符串无公共部分。那就跳出查找，直接返回空串
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args){
        String[] strs = {"flower","flow","flight"};
        String res = longestCommonPrefix(strs);
        System.out.println(res);
        ;
    }
}
