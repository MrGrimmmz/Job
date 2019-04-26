###Lock与ReadWriteLock是两个根接口

###Lock的实现类ReentrantLock

###ReentrantLock特性
- 尝试获得锁

- 获取到锁的线程能够响应中断

- 可以设置公平锁和不公平锁

- tryLock()方法实现 可定时和可轮询的锁获取模式

- lockInterruptibly()方法实现获取可中断锁

- ReenTrantLock 是 JDK 层面实现的

- 使用ReenTrantLock来进行同步，要使用finally块来保证必要时释放锁

- 线程通信通过Condition类来实现

```aidl
Lock lock = new ReentrantLock();
Condition cond = lock.newCondition();
cond.await();
cond.signal();
cond.signalAll();
```

###ReentrantLock与Synchronized的区别
###[参考1](https://www.cnblogs.com/baizhanshi/p/7211802.html)
###[参考2](https://www.cnblogs.com/amberbar/p/10296946.html)

###仅当内置锁不能满足需求时，才可以考虑使用ReentrantLock
 当需要一些高级功能时使用，高级功能包括：
 - 可定时可轮询的与可中断的锁获取操作
 - 公平队列
 - 非块结构的锁
 
 否则，还是应该优先使用Synchronized
 
###ReadWriteLock的实现类ReentrantReadWriteLock
- 它表示两个锁，一个是读操作相关的锁，称为共享锁；一个是写相关的锁，称为排他锁

- 线程进入读锁的前提条件：
  
    - 没有其他线程的写锁，
  
    - 没有写请求或者有写请求，但调用线程和持有锁的线程是同一个。
  
- 线程进入写锁的前提条件：
  
    - 没有其他线程的读锁
  
    - 没有其他线程的写锁
    
- 读写锁有以下三个重要的特性
    - （1）公平选择性：支持非公平（默认）和公平的锁获取方式，吞吐量还是非公平优于公平。
      
      （2）重进入：读锁和写锁都支持线程重进入。
      
      （3）锁降级：遵循获取写锁、获取读锁再释放写锁的次序，写锁能够降级成为读锁。

##[参考](https://blog.csdn.net/j080624/article/details/82790372)


