###Spring事务管理
- 编程式事务管理： 
    - 编程式事务管理使用TransactionTemplate或者直接使用底层的PlatformTransactionManager。对于编程式事务管理，spring推荐使用TransactionTemplate。 
- 声明式事务管理： 
    - 建立在AOP之上的。其本质是对方法前后进行拦截，然后在目标方法开始之前创建或者加入一个事务，在执行完目标方法之后根据执行情况提交或者回滚事务。

- Spring并不直接管理事务，而是提供了多种事务管理器 ，他们将事务管理的职责委托给Hibernate或者JTA等持久化机制所提供的相关平台框架的事务来实现。

- Spring事务管理器的接口是：PlatformTransactionManager
 
- 事务管理器接口 PlatformTransactionManager 通过 getTransaction(TransactionDefinition definition) 方法来得到
一个事务，这个方法里面的参数是 TransactionDefinition类 ，
- TransactionDefinition类定义了一些基本的事务属性：
    - 隔离级别
    - 传播行为
    - 回滚规则
    - 是否只读
    - 事务超时
    
###事务隔离级别
- 定义了一个事务可能受其他并发事务影响的程度

###事务传播行为
- 为了解决业务层方法之间互相调用的事务问题

###回滚规则
- 定义事务回滚规则

###事务只读属性
- 对事物资源是否执行只读操作

###事务超时属性
- 一个事务允许执行的最长时间
