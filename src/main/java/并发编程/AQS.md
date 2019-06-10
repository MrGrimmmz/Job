###AQS
- 在AQS 中， 定义了一个volatile int state 变量作为共享资源，如果线程获
  取资源失败，则进入同步FIFO 队列中等待；如果成功获取资源就执行临界区代码。
  执行完释放资源时，会通知同步队列中的等待线程来获取资源后出队并执行。
  
- AQS 是抽象类， 内置自旋锁实现的同步队列， 封装入队和出队的操作， 提供独
  占、共享、中断等特性的方法。
  
- AQS 的子类可以定义不同的资源实现不同性质的方法

- 可重入锁ReentrantLock ， 定义state 为0 时可以获取资源并置为l 。若已获
  得资源， state 不断加l ， 在释放资源时state 减l ，直至为0 ;
  
- CountDownLatch 初始时
  定义了资源总量state=count, countDown （） 不断将state 减l ，当state=O 时才能获得锁，
  释放后state 就一直为0，所有结程调用await（） 都不会等待，所以CountDownLatch 是
  次性的， 用完后如果再想用就只能重新创建一个
  
- Semaphore 与CountDownLatch 略有不同， 同
  样也是定义了资源总量state=permits ， 当state>0 时就能获得锁， 并将state 减1 ， 当
  state=0 时只能等待其他线程释放锁， 当释放锁时state 加1 ， 其他等待线程又能获得
  这个锁。当Semphore 的permits 定义为1 时，就是互斥锁，当permits> 1 就是共享锁。
  