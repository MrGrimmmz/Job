package 数据结构与算法.算法;

/**
 * @Author ifcc
 * @Date 2018-04-15
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Tree {
    public Tree left;
    public Tree right;
    public int value;
    public Tree(){}
    public Tree(int value){
        this.value=value;
    }
    public Tree(Tree left,Tree right,int value){
        this.value=value;
        this.left=left;
        this.right=right;
    }

}
