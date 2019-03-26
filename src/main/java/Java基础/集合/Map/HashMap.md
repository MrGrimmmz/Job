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
- JDK 1.8 以后哈希表的 添加、删除、查找、扩容方法都增加了一种 节点为 TreeNode 的情况：
    
    - 添加时，当桶中链表个数超过 8 时会转换成红黑树；
    - 删除、扩容时，如果桶中结构为红黑树，并且树中元素个数太少的话，会进行修剪或者直接还原成链表结构；
    - 查找时即使哈希函数不优，大量元素集中在一个桶中，由于有红黑树结构，性能也不会差。

####HashMap的工作原理
* HashMap基于hashing原理，我们通过put()和get()方法储存和获取对象。当我们将
键值对传递给put()方法时，它调用键对象的hashCode()方法来计算hashcode，然后
找到bucket位置来储存值对象。当获取对象时，HashMap会使用键对象的hashcode找到bucket位置，
找到bucket位置之后，会调用keys.equals()方法去找到链表中正确的节点，最终找到要找的值对象。
HashMap使用链表来解决碰撞问题，当发生碰撞了，对象将会储存在链表的下一个节点中。 
HashMap在每个链表节点中储存键值对对象。

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


###equals()与hashCode()
在JAVA语言中，判断两个对象是否相等，一般有两种方法，
- hashcode()
- equals()

这两个方法在判断准确性和效率上有很大的区别

hashCode()方法和equal()方法的作用其实一样，在Java里都是用来对比两个对象是否相等一致，那么equal()既然已经能实现对比的功能了，为什么还要hashCode()呢？

因为重写的equal（）里一般比较全面比较复杂，这样效率就比较低，而利用hashCode()进行对比，则只要生成一个hash值进行比较就可以了，效率很高，那么hashCode()既然效率这么高为什么还要equal()呢？

因为hashCode()并不是完全可靠，有时候不同的对象他们生成的hashcode也会一样（生成hash值得公式可能存在的问题），所以hashCode()只能说是大部分时候可靠，并不是绝对可靠

####区别

1. 原生的equals()比较的也是引用地址，但是重写之后可以比较堆里面的值内容是否相等，一般用于集合元素的比较，避免重复插入

2. hashcode方法只有在集合中用到,根据对象的hash值值计算其物理存储位置

3. 当覆盖了equals方法时，比较对象是否相等将通过覆盖后的equals方法进行比较（判断对象的内容是否相等）。

4. 将对象放入到集合中时，首先判断要放入对象的hashcode值与集合中的任意一个元素的hashcode值是否相等，如果不相等直接将该对象放入集合中。如果hashcode值相等，然后再通过equals方法判断要放入对象与集合中的任意一个对象是否相等，如果equals判断不相等，直接将该元素放入到集合中，否则不放入。

5. 重写equals()方法时需要重写hashCode(),若不重写，就会导致两个equals()判断相等的
对象加入HashMap时，因为返回的HashCode不同而被分在不同的哈希桶中，造成重复添加元素
    - hashCode 方法的常规协定，该协定声明相等对象必须具有相等的哈希码
##比较
两个对象equals，则hashCode一定相等，因为计算方式一样

两个对象不equals，则hashCode不一定不相等,因为可能存在地址冲突

两个对象hashCode相等，对象不一定equals,因为可能存在地址冲突

两个对象hashCode不相等，对象一定不equals
