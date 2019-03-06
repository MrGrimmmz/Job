package 设计模式.单例模式;

/**
 * @author LIFAN
 * 2019/3/5 21:19
 * 懒汉模式
 */
public class Singleton2 {
    //private 修饰对象
    private static Singleton2 instance = null;

    //构造方法私有化
    private Singleton2(){

    }
    //判断，如果是第一次使用该类对象，才new 产生实例化对象
    public static Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }


}
