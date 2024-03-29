###volatile关键字
- 当一个线程修改了这个变量的值，volatile 保证了新值能立即同步到主内存，以及每次使用前立即从主内存刷新。

- 用来确保将变量的更新操作通知到其他线程

- volatile会禁止指令重排序

- 在访问volatile变量时不会执行加锁操作，因此也就不会使执行线程阻塞，因此volatile变量是一种比sychronized关键字更轻量级的同步机制。

###[参考](https://www.cnblogs.com/paddix/p/5428507.html)

###实现原理
- 观察加入volatile关键字和没有加入volatile关键字时所生成的汇编代码发现，加入volatile关键字时，会多出一个lock前缀指令。lock前缀指令其实就相当于一个内存屏障。内存屏障是一组处理指令，用来实现对内存操作的顺序限制。volatile的底层就是通过内存屏障来实现的。

###volatile特性

- volatile具有可见性、有序性

- 可见性是指某线程修改共享变量的指令对其他线程来说都是可见的，它反映的是指令执行的实时透明度。
    - （1）修改volatile变量时会强制将修改后的值刷新的主内存中。
      
    - （2）修改volatile变量后会导致其他线程工作内存中对应的变量值失效。因此，再读取该变量值的时候就需要重新从读取主内存中的值。
      
- 禁止指令重排序优化
    - 有volatile修饰的变量，赋值后多执行了一个“load addl $0x0, (%esp)”操作，这个操作相当于一个内存屏障（指令重排序时不能把后面的指令重排序到内存屏障之前的位置）

- 不具备原子性
    - 假如多个线程同时执行i++，volatile只能保证他们操作的i是同一块内存，但依然可能出现写入脏数据的情况。 
    - volatile是无法保证这三个操作是具有原子性的，我们可以通过AtomicInteger或者Synchronized来保证+1操作的原子性

###volatile使用场景

- 适用于读多写少的场景

- volatile一写多读最典型的应用是CopyOnWriteArrayList。它在修改数据时会把整个集合的数据全部复制出来，
  对写操作加锁，修改完成后， 再用setArray（） 把array 指向新的集合。使用volatile 可
  以便读线程尽快地感知array 的修改， 不进行指令重排，操作后即对其他线程可见。

- JDK中volatie应用：JDK中ConcurrentHashMap的Entry的value和next被声明为volatile，AtomicLong中的value被声明为volatile。AtomicLong通过CAS原理(也可以理解为乐观锁)保证了原子性。

###volatile 性能：

- volatile 的读性能消耗与普通变量几乎相同，但是写操作稍慢，因为它需要在本地代码中插入许多内存屏障指令来保证处理器不发生乱序执行。

###volatile和synchronized的区别
- volatile本质是在告诉jvm当前变量在寄存器（工作内存）中的值是不确定的，需要从主存中读取； synchronized则是锁定当前变量，只有当前线程可以访问该变量，其他线程被阻塞住。
   
- volatile仅能使用在变量级别；synchronized则可以使用在变量、方法、和类级别的
   
- volatile仅能实现变量的修改可见性，不能保证原子性；而synchronized则可以保证变量的修改可见性和原子性
   
- volatile不会造成线程的阻塞；synchronized可能会造成线程的阻塞。
   
- volatile标记的变量不会被编译器优化；synchronized标记的变量可以被编译器优化

###Atomic、volatile、synchronized、ThreadLocal优缺点比较
[参考](https://blog.csdn.net/wang123459/article/details/79035939)
