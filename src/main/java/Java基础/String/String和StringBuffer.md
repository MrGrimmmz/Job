###String、StringBuffer和StringBuilder的区别以及使用场景
* String类型和StringBuffer类型的主要性能区别其实在于String是不可变的对象, 因此在每次对String
类型进行改变的时候其实都等同于生成了一个新的String对象，然后将指针指向新的String对象，
所以经常改变内容的字符串最好不要用String

* 如果是使用StringBuffer类则结果就不一样了，每次结果都会对StringBuffer对象本身进行操作，
而不是生成新的对象
* StringBuilder：线程非安全的；StringBuffer：线程安全的

####总结
* 如果要操作少量的数据用 String

* 单线程操作字符串缓冲区下操作大量数据 StringBuilder
* 多线程操作字符串缓冲区下操作大量数据 StringBuffer

###StringBuffer的常用方法
- append方法
 
- deleteCharAt方法

- insert方法
    - public StringBuffer insert(int offset, boolean b)
    - 该方法的作用是在StringBuffer对象中插入内容，然后形成新的字符串。

- reverse方法
    - 该方法的作用是将StringBuffer对象中的内容反转，然后形成新的字符串
    
- setCharAt方法

- trimToSize方法
    - 该方法的作用是将StringBuffer对象的中存储空间缩小到和字符串长度一样的长度，减少空间的浪费。