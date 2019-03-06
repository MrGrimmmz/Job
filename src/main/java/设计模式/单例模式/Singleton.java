package 设计模式.单例模式;

/**
 * @author LIFAN
 * 2019/3/5 21:18
 * 饿汉模式
 * 饿汉式在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的
 */

public class Singleton {

    //构造函数私有化
    private Singleton(){

    }

    //实例化放在静态代码块里可提高程序的执行效率，但也可能更占用空间
    private static final Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }

}
