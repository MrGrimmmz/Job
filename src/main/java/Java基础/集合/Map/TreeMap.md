###简介
- 与HashMap相比，TreeMap是一个能比较元素大小的Map集合，会对传入的key进行了大小排序。其中，可以使用元素的自然顺序，也可以使用集合中自定义的比较器来进行排序；

- TreeMap继承于AbstractMap，实现了Map, Cloneable, NavigableMap, Serializable接口。

[参考](https://www.jianshu.com/p/2dcff3634326)

###特点
1. 无序，不允许重复（无序指元素顺序与添加顺序不一致） 

2. TreeMap集合默认会对键进行排序，所以键必须实现自然排序和定制排序中的一种 

3. 底层使用的数据结构是二叉树

- 当未实现 Comparator 接口时，key 不可以为null，否则抛 NullPointerException 异常；

- 当实现 Comparator 接口时，若未对 null 情况进行判断，则可能抛 NullPointerException 异常。如果针对null情况实现了，可以存入，但是却不能正常使用get()访问，只能通过遍历去访问。

- value可以为NULL