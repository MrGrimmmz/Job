package 编程题.笔试题.京东.ti2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author LIFAN
 * 2019/4/13 19:53
 */
public class Main {
    //前缀树节点结构
    static class TrieNode {

        /**
         * true 关键词的终结 ； false 继续
         */
        private boolean end = false;

        /**
         * key下一个字符，value是对应的节点
         */
        private Map<Character, TrieNode> subNodes = new HashMap<Character, TrieNode>();

        /**
         * 向指定位置添加节点树
         */
        void addSubNode(Character key, TrieNode node) {
            subNodes.put(key, node);
        }

        /**
         * 获取下个节点
         */
        TrieNode getSubNode(Character key) {
            return subNodes.get(key);
        }

        boolean isKeywordEnd() {
            return end;
        }

        void setKeywordEnd(boolean end) {
            this.end = end;
        }
        public int getSubNodeCount() {
            return subNodes.size();
        }
    }

    /**
     * 根节点
     */
    private static TrieNode rootNode = new TrieNode();

    //构建前缀树结构
    private static void addWord(String lineTxt) {
        TrieNode tempNode = rootNode;
        // 循环每个字节
        for (int i = 0; i < lineTxt.length(); ++i) {
            Character c = lineTxt.charAt(i);
            TrieNode node = tempNode.getSubNode(c);
            // 没初始化
            if (node == null) {
                node = new TrieNode();
                tempNode.addSubNode(c, node);
            }

            tempNode = node;

            if (i == lineTxt.length() - 1) {
                // 关键词结束， 设置结束标志
                tempNode.setKeywordEnd(true);
            }
        }
    }

    public static int filter(String text) {
        String replacement = "";
        StringBuilder result = new StringBuilder();

        TrieNode tempNode = rootNode;
        // 回滚数
        int begin = 0;
        int count = 0;
        // 当前比较的位置
        int position = 0;

        while (position < text.length()) {
            char c = text.charAt(position);

            // 读取该字符对应的子节点
            tempNode = tempNode.getSubNode(c);

            // 不存在，换下个字符开头
            if (tempNode == null) {
                // 以begin开始的字符串不存在敏感词
                result.append(text.charAt(begin));
                // 跳到下一个字符开始测试
                position = begin + 1;
                begin = position;
                // 回到树初始节点
                tempNode = rootNode;
            } else if (tempNode.isKeywordEnd()) {
                // 发现敏感词， 从begin到position的位置用replacement替换掉
                count++;
                result.append(replacement);
                position = position + 1;
                begin = position;
                tempNode = rootNode;
            } else {
                // 有这个词，但不是敏感词，继续看看后面的词
                ++position;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        String[] strs = new String[m];

        for(int i=0;i<m;i++){
            strs[i] = in.next();
            addWord(strs[i]);
        }

        String strT = in.next();
        System.out.println(filter(strT));

    }


}
