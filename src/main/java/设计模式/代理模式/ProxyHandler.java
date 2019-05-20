package 设计模式.代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author LIFAN
 * 2019/5/20 17:54
 */
public class ProxyHandler implements InvocationHandler {
    private Object tar;

    //绑定委托对象，并返回代理类
    public Object bind(Object tar) {
        this.tar = tar;
        //绑定该类实现的所有接口，取得代理类
        return Proxy.newProxyInstance(tar.getClass().getClassLoader(),
                tar.getClass().getInterfaces(),
                this);
    }

    //不依赖具体接口实现
    public Object invoke(Object proxy , Method method , Object[] args) throws Throwable {
        Object result = null;//被代理的类型为Object基类

        //这里就可以进行所谓的AOP编程了
        //在调用具体函数方法前，执行功能处理
        System.out.println( "before" );

        //JVM通过这条语句执行原来的方法(反射机制)
        result = method.invoke(tar,args);

        //在调用具体函数方法后，执行功能处理
        System.out.println( "after" );

        return result;
    }
}
