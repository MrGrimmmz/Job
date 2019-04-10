
##[参考1](http://www.importnew.com/28263.html)

##[参考2](https://www.jianshu.com/p/95a9a82d7a1c)

####ConcurrentHashMap
* 底层采用分段的数组+链表实现，线程安全
* 通过把整个Map分为N个Segment，可以提供相同的线程安全，但是效率提升N倍，默认
提升16倍。

* HashTable的synchronized是针对整张Hash表的，即每次锁住整张表让线程独占，
ConcurrentHashMap允许多个修改操作并发进行，其关键在于使用了锁分离技术
* 有些方法需要跨段，比如size()和containsValue()，它们可能需要锁定整个表
而而不仅仅是某个段，这需要按顺序锁定所有段，操作完毕后，又按顺序释放所有段的锁
* 扩容：段内扩容（段内元素超过该段对应Entry数组长度的75%触发扩容，不会对整个
Map进行扩容），插入前检测需不需要扩容，有效避免无效扩容

####ConcurrentHashMap的工作原理（Java 1.7）
* ConcurrentHashMap采用了非常精妙的"分段锁"策略，ConcurrentHashMap的主干
是个Segment数组。
* Segment继承了ReentrantLock，所以它就是一种可重入锁（ReentrantLock)。
在ConcurrentHashMap，一个Segment就是一个子哈希表，Segment里维护了一个
HashEntry数组，并发环境下，对于不同Segment的数据进行操作是不用考虑锁竞争的。
所以，对于同一个Segment的操作才需考虑线程同步，不同的Segment则无需考虑。

* 一个ConcurrentHashMap维护一个Segment数组，一个Segment维护一个HashEntry数组。
* 初始化方法有三个参数，如果用户不指定则会使用默认值，initialCapacity为16，
loadFactor为0.75（负载因子，扩容时需要参考），concurrentLevel为16,Segment数组
的大小ssize是由concurrentLevel来决定的，但是却不一定等于concurrentLevel，
ssize一定是大于或等于concurrentLevel的最小的2的次幂

* put的主要逻辑就两步：
* > 1.定位segment并确保定位的Segment已初始化 
* > 2.调用Segment的put方法

* get读操作不加锁，由于HashEntry的value变量是volatile的，volatile可以保证
内存可见性，所以不会读取到过期数据