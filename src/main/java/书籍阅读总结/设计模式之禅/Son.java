package 书籍阅读总结.设计模式之禅;


import 书籍阅读总结.设计模式之禅.Father;

import java.util.Random;
import java.util.Stack;


/**
 * @Author ifcc
 * @Date 2018-05-21
 * @School SouthEast University {@see java.lang.System}
 * @verstion 1.0
 */
public class Son extends Father {

    public Son(int i){

    }

    @Override
    public Son invoke(Son son) {
        Son t=Test.test;
        try {
            Object clone = t.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return new Son(1);
    }

    public void print(){
        super.print();
    }

    @Override
    public String toString(){
        return "son";
    }

    public void intPrint(int...args){
        System.out.println(args.getClass());
    }

    public void intPrint(char...args){
        System.out.println(args.getClass());
    }

    public void intPrint(long...args){
        System.out.println(args.getClass());
    }

    private static  class Test{
        private static  Son test=new Son(1);
    }

    public int val=3;
    public static void main(String[] args){
        /*System.out.println("A处线程：" + Thread.currentThread().getName() + ", 所属线程：" + Thread.currentThread().getThreadGroup().getName() +
                ", 组中有线程组数量：" + Thread.currentThread().getThreadGroup().activeGroupCount());
        ThreadGroup group = new ThreadGroup("新的组");
        System.out.println("B处线程：" + Thread.currentThread().getName() + ", 所属线程：" + Thread.currentThread().getThreadGroup().getName() +
                ", 组中有线程组数量：" + Thread.currentThread().getThreadGroup().activeGroupCount());
        ThreadGroup[] tg = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
        Thread.currentThread().getThreadGroup().enumerate(tg);
        for (int i = 0; i < tg.length; i++)
            System.out.println("第一个线程组名称为：" + tg[i].getName());
        System.out.println("B处线程：" + Thread.currentThread().getName() + ", 所属线程：" + Thread.currentThread().getThreadGroup().getName() +
                ", 组中有线程组数量：" + Thread.currentThread().getThreadGroup().activeGroupCount());*/
        /*System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));*/
       /* Random random = new Random(10);
        System.out.println(random.nextInt(100));
        System.out.println(random.nextInt(100));
        System.out.println(random.nextInt(100));
        System.out.println(random.nextInt(100));*/
        Integer n1 = 200;
        Integer n2 = 200;
        boolean c1=n1==78;
        boolean c2=n1==78;
        int i=021;
        long k=07;
        //boolean c2=n2/i!=0;
        System.out.println(0xffff<<5);
        System.out.println(c1);
        short a=1;
        short b=1;
        a+=b;
        System.out.println((char)0);
        System.out.println(n1==n2);
        Son son = new Son(1);
        son.print();

    }
}
