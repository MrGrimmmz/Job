package 设计模式.代理模式;

/**
 * @author LIFAN
 * 2019/5/20 17:55
 */
public class Test {
    public static void main(String args[])
    {
        ProxyHandler proxy = new ProxyHandler();
        //绑定该类实现的所有接口
        Subject sub = (Subject) proxy.bind(new RealSubject());
        sub.doSomething();
    }
}
