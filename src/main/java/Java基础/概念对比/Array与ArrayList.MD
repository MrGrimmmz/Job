###区别
- 存储内容比较：
    - Array数组可以包含基本类型和对象类型，
    - ArrayList却只能包含对象类型。
    
- 空间大小比较：
  
  - Array的空间大小是固定的，空间不够时也不能再次申请，所以需要事前确定合适的空间大小。
  - ArrayList的空间是动态增长的，如果空间不够，它会创建一个空间比原空间大约0.5倍的新数组，然后将所有元素复制到新数组中，接着抛弃旧数组。而且，每次添加新的元素的时候都会检查内部数组的空间是否足够。（比较麻烦的地方）。
  
- 方法上的比较： 
  - ArrayList作为Array的增强版，当然是在方法上比Array更多样化，比如添加全部addAll()、删除全部removeAll()、返回迭代器iterator()等。
  