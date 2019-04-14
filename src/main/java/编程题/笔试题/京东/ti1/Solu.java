package 编程题.笔试题.京东.ti1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author LIFAN
 * 2019/4/13 20:25
 */
public class Solu {

    static class Node {
        private int data;
        private Node leftNode;
        private Node rightNode;
        public Node(int data, Node leftNode, Node rightNode){
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        public int getData() {
            return data;
        }
        public void setData(int data) {
            this.data = data;
        }
        public Node getLeftNode() {
            return leftNode;
        }
        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }
        public Node getRightNode() {
            return rightNode;
        }
        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }
    }


    public static int TreeDepth(Node root) {
        if(root==null){
            return 0;
        }

        int nLeft=TreeDepth(root.leftNode);
        int nRight=TreeDepth(root.rightNode);

        return nLeft>nRight?(nLeft+1):(nRight+1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //int m = in.nextInt();

        Map<Integer,Node> map = new HashMap<Integer,Node>();

        int m = 6;
        Node root = new Node(1,null,null);

        map.put(1,root);

        String[] strs = new String[5];
        strs[0] = "2 1";
        strs[1] = "3 2";
        strs[2] = "4 3";
        strs[3] = "5 2";
        strs[4] = "6 1";

        for(int i=0;i<m-1;i++){
            String[] line = strs[i].split(" ");
            Node node = new Node(Integer.valueOf(line[0]),null,null);
            map.put(Integer.valueOf(line[0]),node);
            Node temp = map.get(Integer.valueOf(line[1]));
            if(temp.leftNode == null){
                temp.setLeftNode(node);
            }else if(temp.rightNode == null){
                temp.setRightNode(node);
            }
        }

        int result = TreeDepth(root);
        System.out.println(result);

    }


}
