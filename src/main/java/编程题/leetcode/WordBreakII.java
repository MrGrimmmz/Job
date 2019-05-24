package 编程题.leetcode;


/**
 * @author LIFAN
 * 2019/5/24 14:45
 * Given a string s and a dictionary of words dict,
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 * A solution is["cats and dog", "cat sand dog"].
 */
import java.util.*;
public class WordBreakII {
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        return DFS(s, dict, new HashMap<String, ArrayList<String>>());
    }

    public static ArrayList<String> DFS(String s, Set<String> wordDict, HashMap<String, ArrayList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);
        ArrayList<String> res = new ArrayList<String>();

        if (s.length() == 0){
            res.add("");
            return res;
        }
        for (String subStr : wordDict) {
            if (s.startsWith(subStr)) {
                for (String str : DFS(s.substring(subStr.length()), wordDict, map)) {
                    res.add(subStr + (str == "" ? "" : " ")+ str);
                }
            }
        }
        map.put(s, res);
        return res;
    }


    public static void main(String[] args){
        Set<String> dict = new HashSet<String>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        System.out.println(wordBreak("catsanddog",dict));
    }
}