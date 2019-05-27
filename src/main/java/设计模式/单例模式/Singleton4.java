package 设计模式.单例模式;

/**
 * @author LIFAN
 * 2019/3/5 21:56
 * 静态内部类
 * 既实现了线程安全，又避免了同步带来的性能影响。
 */
public class Singleton4 {

    private static class InnerObject {
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    private Singleton4 (){
    }

    public static final Singleton4 getInstance() {
        return InnerObject.INSTANCE;
    }

}
