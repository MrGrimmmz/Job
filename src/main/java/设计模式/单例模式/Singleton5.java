package 设计模式.单例模式;

/**
 * @author LIFAN
 * 2019/3/6 15:45
 * 枚举
 */
public enum Singleton5 {
    Instance;
    private SingletonEntity singleton;

    public SingletonEntity getInstance(){
        singleton = new SingletonEntity();
        return singleton;
    }
}

//SingletonEntity singleton = Singleton.Instance.getInstance();




