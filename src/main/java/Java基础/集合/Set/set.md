###List和Set的区别
* 均继承Collection接口
* Set接口，无序，不允许重复。具体的Set实现类依赖添加的对象的equals()方法来检查等同性
* List接口，有序，允许重复
* > ArrayList: 读快改慢,由数组实现的List。允许对元素进行快速随机访问，插入与移除元素的速度很慢
* > LinkedList: 改快读慢,向List中间插入与删除的开销并不大，随机访问则相对较慢, 
可以当作链表、堆栈、队列和双向队列使用

* Set：检索元素效率低下，删除和插入效率高，插入和删除不会引起元素位置改变。
* List：和数组类似，List可以动态增长，查找元素效率高，插入删除元素效率低，
因为会引起其他元素位置改变。

###HashSet、LinkedHashSet、TreeSet
* 每一个存储到哈希表中的对象，都得提供hashCode()和equals()方法的实现，用来判断是否是同一个对象，
对于HashSet集合，我们要保证如果两个对象通过equals()方法返回true这两个对象的hashCode值也应该相同。
####共同点：
* 1、都不允许元素重复
* 2、都不是线程安全的类，解决办法：Set set = Collections.synchronizedSet(set 对象)
####不同点：
* > HashSet:不保证元素的添加顺序，底层采用哈希表算法，查询效率高。判断两个元素是否相等,
equals()方法返回true,hashCode() 值相等。即要求存入 HashSet 中的元素要覆盖 equals() 方法
和 hashCode()方法
* > LinkedHashSet:HashSet 的子类，底层采用了哈希表算法以及 链表算法，既保证了元素的添加顺序，
也保证了查询效率。但是整体性能要低于 HashSet　　　　
* > TreeSet:不保证元素的添加顺序，但是会对集合中的元素进行排序。
底层采用红-黑树算法（树结构比较适合范围查询）