###三种常见的锁状态
- 对于普通的同步方法： 
    - 锁是当前的对象 
- 对于静态函数的同步方法： 
    - 锁是指引用当前类的class对象 
- 对于同步方法块的内容： 
    - 锁是指Synchonized括号里配置的对象
    
###Synchonized
- synchronized 是依赖于 JVM 实现的

- 线程通信通过Object类提供的wait(),notify(),notifyAll()三个方法来实现
