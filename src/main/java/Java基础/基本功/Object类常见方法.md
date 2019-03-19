###Object类是所有类公共的父类

###分类
1. 构造函数 
2. hashCode和equale函数用来判断对象是否相同, 
3. wait(),wait(long),wait(long,int),notify(),notifyAll(),体现的是Java的多线程机制 
4. toString()和getClass, 经常用于java反射机制
5. clone(),用来另存一个当前存在的对象
6. finalize()用于在垃圾回收

###主要的方法
1、public Object(){} ------构造方法

2、public boolean equals(Object obj){} -------对象的比较

3、public int hashCode(){}--------取得对象对应的哈希码

4、public String toString(){}--------打印对象信息（属性值）
