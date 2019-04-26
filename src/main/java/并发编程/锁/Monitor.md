##什么是Monitor？
1. Monitor是一种用来实现同步的工具
2. 与每个java对象相关联，即每个java对象都有一个Monitor与之对应
3. Monitor是实现Sychronized(内置锁)的基础

##Monitor的基本结构是什么？
1. Owner字段：初始时为NULL表示当前没有任何线程拥有该monitor record，当线程成功拥有该锁后保存线程唯一标识，当锁被释放时又设置为NULL
2. EntryQ字段：关联一个系统互斥锁（semaphore），阻塞所有试图锁住monitor record失败的线程
3. RcThis字段：表示blocked或waiting在该monitor record上的所有线程的个数
4. Nest字段：用来实现重入锁的计数
5. HashCode字段：保存从对象头拷贝过来的HashCode值（可能还包含GC age）
6. Candidate字段：用来避免不必要的阻塞或等待线程唤醒，因为每一次只有一个线程能够成功拥有锁，如果每次前一个释放锁的线程唤醒所有正在阻塞或等待的线程，会引起不必要的上下文切换（从阻塞到就绪然后因为竞争锁失败又被阻塞）从而导致性能严重下降；Candidate只有两种可能的值0表示没有需要唤醒的线程1表示要唤醒一个继任线程来竞争锁



##java对象堆内存结构
java对象在堆中的基本内存结构，分为三个部分：
1. 对象头(header)：包括Mark Word(标记字段)和Class Pointer(类型指针)
2. 实例数据(instance data)：对象真正存储的有效信息，即代码中定义的各种类型的字段内容
3. 对齐填充(padding)：由HotSpot虚拟机定义对象起始地址必须是8字节整数倍，当不是整数倍时，需要填充数据补齐，因为对补齐的数据访问只需要一次内存访问即可

##Monitor与java对象以及线程是如何关联的？
1. 如果一个java对象被某个线程锁住，则该java对象的Mark Word字段中LockWord指向monitor的起始地址
2. Monitor的Owner字段会存放拥有相关联对象锁的线程id

##Monitor具体是怎么实现的？
1. Monitor是在jvm底层实现的，底层代码是c++
2. Monitor的enter方法：获取锁
3. Monitor的exit方法：释放锁
4. Monitor的wait方法：为java的Object的wait方法提供支持
5. Monitor的notify方法：为java的Object的notify方法提供支持
6. Monitor的notifyAll方法：为java的Object的notifyAll方法提供支持