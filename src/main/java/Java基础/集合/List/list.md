###List集合
- 简介
    - List集合代表一个元素有序、可重复的集合，集合中每个元素都有其对应的顺序索引。List集合允许使用重复元素，可以通过索引来访问指定位置的集合元素 。List集合默认按元素的添加顺序设置元素的索引，例如第一个添加的元素索引为0，第二个添加的元素索引为1......
    
    - List作为Collection接口的子接口，可以使用Collection接口里的全部方法。而且由于List是有序集合，因此List集合里增加了一些根据索引来操作集合元素的方法。

- 接口中定义的方法
    - void add(int index, Object element): 在列表的指定位置插入指定元素（可选操作）。
    - **boolean addAll(int index, Collection<? extends E> c) : ** 将集合c 中的所有元素都插入到列表中的指定位置index处。
    - Object get(index):返回列表中指定位置的元素。
    - int indexOf(Object o): 返回此列表中第一次出现的指定元素的索引；如果此列表不包含该元素，则返回 -1。
    - int lastIndexOf(Object o):返回此列表中最后出现的指定元素的索引；如果列表不包含此元素，则返回 -1。
    - **Object remove(int index): ** 移除列表中指定位置的元素。
    - Object set(int index, Object element):用指定元素替换列表中指定位置的元素。
    - **List subList(int fromIndex, int toIndex): **返回列表中指定的 fromIndex（包括 ）和 toIndex（不包括）之间的所有集合元素组成的子集。
    - Object[] toArray(): 返回按适当顺序包含列表中的所有元素的数组（从第一个元素到最后一个元素）。
    
    - 除此之外，Java 8还为List接口添加了如下两个默认方法。
    - void replaceAll(UnaryOperator operator):根据operator指定的计算规则重新设置List集合的所有元素。
    - void sort(Comparator c):根据Comparator参数对List集合的元素排序。

###ArrayList与LinkedList
- ArrayList 数组结构：改查效率高，通过索引不需要遍历
- LinkedList 链表结构：增删效率高，只修改前后指针

###在ArrayLIst和LinkedList尾部加元素,谁的效率高
当输入的数据一直是小于千万级别的时候，大部分是LinkedList效率高，而当数据量大于千万级别的时候，就会出现ArrayList的效率比较高了。为什么呢？

原来 LinkedList每次增加的时候，会new 一个Node对象来存新增加的元素，所以当数据量小的时候，这个时间并不明显，而ArrayList需要扩容，所以LinkedList的效率就会比较高，其中如果ArrayList出现不需要扩容的时候，那么ArrayList的效率应该是比LinkedList高的，当数据量很大的时候，new对象的时间大于扩容的时间，那么就会出现ArrayList的效率比LinkedList高了