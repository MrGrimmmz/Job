###Person p = new Person();

1. 加载Person.class文件到方法区，同时加载Person类中的static属性

2. 在main方法所在的栈区分配引用(reference) p；

3. 在java堆中开辟空间存放Person类，但是不进行初始化操作。

4. 默认初始化数据

5. 将引用p指向java中新开辟的Person类