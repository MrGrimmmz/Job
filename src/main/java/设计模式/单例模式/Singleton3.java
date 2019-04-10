package 设计模式.单例模式;

/**
 * @author LIFAN
 * 2019/3/5 21:39
 * 懒汉-线程安全
 * 双重检查锁定
 */
public class Singleton3 {
    //private static Singleton3 singleton = null;
    private volatile static  Singleton3 singleton = null;
    private Singleton3(){

    }

/*    //在方法调用上加了同步，虽然线程安全了，但是每次都要同步，会影响性能，毕竟99%的情况下是不需要同步的，
public static synchronized Singleton3 getInstance(){
        if(singleton == null){
                if(singleton == null){
                    singleton = new Singleton3();
                }
        }
        return singleton;
    }*/

//在getInstance中做了两次null检查，确保了只有第一次调用单例的时候才会做同步，这样也是线程安全的，
// 同时避免了每次都同步的性能损耗
    public static Singleton3 getInstance(){
        if(singleton == null){
            synchronized(Singleton3.class){
                if(singleton == null){
                    singleton = new Singleton3();
                }
            }
        }
        return singleton;
    }
}
