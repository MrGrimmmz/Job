package 设计模式.代理模式;

/**
 * @author LIFAN
 * 2019/5/20 17:53
 */
public class RealSubject implements Subject {
    public void doSomething() {
        System.out.println( "call doSomething()" );
    }
}
