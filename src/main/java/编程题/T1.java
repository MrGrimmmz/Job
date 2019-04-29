package 编程题;


/**
 * 使用多线程对file.txt进行英文单词统计，将结果按照出现次数从多到少以“单词,count“形式保存到wordcount.txt文件，每个单词一行
 * 备注：英文单词不区分大小写，最后统一小写字母输出
 */
public class T1 {

    static int x=10;
    static{
        x+=5;
    }
    public static void main(String[] args) {

        System.out.println("x="+ x);
    }
    static{
        x/=3;
    }


}
