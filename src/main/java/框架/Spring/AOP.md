##面向切面编程
- Aspect Oriented Programming，面向切面编程
- 在OOP中，正是这种分散在各处且与对象核心功能无关的代码（横切代码）的存在，使得模块复用难度增加。
AOP则将封装好的对象剖开，找出其中对多个对象产生影响的公共行为，并将其封装为一个可重用的模块，这个模块被命名为“切面”（Aspect），
- 切面将那些与业务无关，却被业务模块共同调用的逻辑提取并封装起来，减少了系统中的重复代码，降低了模块间的耦合度，同时提高了系统的可维护性。
- AOP的关键单元是切面，或者说关注点（可以简单地理解为你程序中的独立模块）
- 是一种可以通过预编译方式和运行期动态代理实现在不修改源代码的情况下给程序动态统一添加功能的一种技术。

- Spring AOP通过以下两种方式来使用
    - 使用AspectJ 注解风格(主要方式)
    - 使用Spring XML 配置风格

###Spring AOP
- Spring中的AOP代理还是离不开Spring的IOC容器，代理的生成，管理及其依赖关系都是由IOC容器负责，Spring默认使用JDK动态代理，在需要代理类而不是代理接口的时候，Spring会自动切换为使用CGLIB代理，不过现在的项目都是面向接口编程，所以JDK动态代理相对来说用的还是多一些。

###AOP有哪些可用的实现？
基于Java的主要AOP实现有：

- AspectJ
- Spring AOP
- JBoss AOP

###Spring中有哪些不同的通知类型
- 前置通知(Before Advice): 
    - 在连接点之前执行的Advice，不过除非它抛出异常，否则没有能力中断执行流。使用 @Before 注解使用这个Advice。

- 返回之后通知(After Retuning Advice): 
    - 在连接点正常结束之后执行的Advice。例如，如果一个方法没有抛出异常正常返回。通过 @AfterReturning 关注使用它。

- 抛出（异常）后执行通知(After Throwing Advice): 
    - 如果一个方法通过抛出异常来退出的话，这个Advice就会被执行。通用 @AfterThrowing 注解来使用。

- 后置通知(After Advice): 
    - 无论连接点是通过什么方式退出的(正常返回或者抛出异常)都会执行在结束后执行这些Advice。通过 @After 注解使用。

- 围绕通知(Around Advice): 
    - 围绕连接点执行的Advice，就你一个方法调用。这是最强大的Advice。通过 @Around 注解使用。

###通知执行的优先级
- 进入目标方法时,先织入Around,再织入Before，退出目标方法时，先织入Around,再织入AfterReturning,最后才织入After。

- 注意:Spring AOP的环绕通知会影响到AfterThrowing通知的运行,不要同时使用!同时使用也没啥意义。

###连接点(Joint Point)和切入点(Point cut)是什么？
- 连接点是程序执行的一个点。例如，一个方法的执行或者一个异常的处理。在 Spring AOP 中，一个连接点总是代表一个方法执行。举例来说，所有定义在你的 EmpoyeeManager 接口中的方法都可以被认为是一个连接点，如果你在这些方法上使用横切关注点的话。

- 切入点(切入点)是一个匹配连接点的断言或者表达式。Advice 与切入点表达式相关联，并在切入点匹配的任何连接点处运行（比如，表达式 execution(* EmployeeManager.getEmployeeById(...)) 可以匹配 EmployeeManager 接口的 getEmployeeById() ）。由切入点表达式匹配的连接点的概念是 AOP 的核心。Spring 默认使用 AspectJ 切入点表达式语言。

###切入点的定义和表达式
Spring AOP支持的切入点指示符：
```aidl
- @Pointcut("execution(* com.aijava.springcode.service..*.*(..))")
第一个*表示匹配任意的方法返回值，..(两个点)表示零个或多个，上面的第一个..表示service包及其子包,第二个*表示所有类,第三个*表示所有方法，第二个..表示
方法的任意参数个数
```

###Spring AOP 代理是什么？
- AOP 代理是一个由 AOP 框架创建的用于在运行时实现切面协议的对象
    - JDK代理：对于实现接口的业务对象
    - CGLIB代理：没有实现任何接口的对象

###JDK代理
- JDK的动态代理要使用到一个类 Proxy 用于创建动态代理的对象，

- 一个接口 InvocationHandler用于监听代理对象的行为，

- 其实动态代理的本质就是对代理对象行为的监听。

- JDK动态代理核心还是一个InvocationHandler，记住这个就行了

##使用场景
- 权限控制
- 异常处理
- 缓存
- 事务管理
- 日志记录
- 数据校验

###例子
- (1)实现InvocationHandler接口
  
- (2)创建代理类(通过java API)
  
  Proxy.newProxyInstance(动态加载代理类,代理类实现接口,使用handler);
  
- (3)调用invoke方法(虚拟机自动调用方法)


```$xslt
public interface Animal {
        public void run();
        public void jump();
}
    
public class Dog implements Animal{
    public void run(){
        System.out.println("小狗开始跑！");
    }    
    public void jump(){
        System.out.println("小狗开始跳！");
    }        
}
```

```$xslt
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy  implements InvocationHandler{

    private Object targetObject;
    
    /** 
     * 绑定委托对象并返回一个代理类 
     * @param target 
     * @return 
     */  
    public Object createProxyInstance(Object targetObject) {
        this.targetObject = targetObject;        
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), 
                               targetObject.getClass().getInterfaces(), 
                               this);
    }
    
    /**
     * @param proxy：指被代理的对象。
     * @param method：要调用的方法
     * @param args：方法调用时所需要的参数 
     */    
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        //注入需要调用的方法
        command();        
        //执行被代理对象的方法，如果方法有返回值则赋值给ret
        Object ret = method.invoke(targetObject, args);
        //注入需要调用的方法
        award();
        return ret;
    }
    
    
    private void command() {
        System.out.println("驯兽师发出命令！");
    }
    private void award(){
        System.out.println("驯兽师给与奖励！");
    }
}
```

调用

```$xslt
public class Client {
    public static void main(String[] args) {
        MyProxy hander = new MyProxy();
        Animal dog = (Animal)hander.createProxyInstance(new Dog());
        dog.run();
        dog.jump();
    }
}
```

