####HashTable

* 底层数组+链表实现，无论key还是value都不能为null，线程安全，
实现线程安全的方式是在修改数据时锁住整个HashTable，效率低，ConcurrentHashMap
做了相关优化
* 初始size为11，扩容：newsize = oldsize*2+1

####HashMap
* 底层数组+链表实现，可以存储null键和null值，线程不安全
* 初始size为16，扩容：newsize = oldsize*2，size一定为2的n次幂
* 扩容针对整个Map，每次扩容时，原来数组中的元素依次重新计算存放位置，并重新插入
* 当Map中元素总数超过Entry数组的75%，触发扩容操作，为了减少链表长度，元素分配更均匀

- JDK1.8引入红黑树大程度优化了HashMap的性能。
####HashMap的工作原理
* HashMap基于hashing原理，我们通过put()和get()方法储存和获取对象。当我们将
键值对传递给put()方法时，它调用键对象的hashCode()方法来计算hashcode，然后
找到bucket位置来储存值对象。当获取对象时，通过键对象的equals()方法找到正确
的键值对，然后返回值对象。HashMap使用链表来解决碰撞问题，当发生碰撞了，对象
将会储存在链表的下一个节点中。 HashMap在每个链表节点中储存键值对对象。

* 当两个不同的键对象的hashcode相同时会发生什么？ 它们会储存在同一个bucket
位置的链表中。通过keys.equals()方法用来找到键值对。

* 使用不可变的、声明作final的对象，并且采用合适的equals()和hashCode()方法的话，
将会减少碰撞的发生，提高效率。不可变性使得能够缓存不同键的hashcode，这将提高整个
获取对象的速度，使用String，Interger这样的wrapper类作为键是非常好的选择。

* 默认的负载因子大小为0.75，也就是说，当一个map填满了75%的bucket时候，和其它集合
类(如ArrayList等)一样，将会创建原来HashMap大小的两倍的bucket数组，来重新调整map
的大小，并将原来的对象放入新的bucket数组中。这个过程叫作rehashing，因为它调用hash
方法找到新的bucket位置

* HashMap多线程的条件竞争,重新调整HashMap大小的时候,存在条件竞争

* 重写equals()方法时需要重写hashCode(),若不重写，就会导致两个equals()判断相等
的对象加入HashMap时，因为返回的HashCode不同而被分在不同的哈希桶中，造成重复添加
元素

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

####ConcurrentHashMap的工作原理
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