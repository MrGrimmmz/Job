###相同的地方
他们都是java的一个接口, 并且是用来对自定义的class比较大小的

###区别
- Comparable

    - Comparable 定义在 Person类的内部:
    ```aidl
    public class Person implements Comparable {
         String name;
         int age
         public int compareTo(Person another) {
              int i = 0;
              i = name.compareTo(another.name); // 使用字符串的比较
              if(i == 0) { // 如果名字一样,比较年龄, 返回比较年龄结果
                   return age - another.age;
              } else {
                   return i; // 名字不一样, 返回比较名字的结果.
              }
         }
    }
  这时我们可以直接用 Collections.sort( personList ) 对其排序了.
    ```
    - 好处：简单实现，只需实现Comparable接口即可
    - 但需要修改源代码
    
    
- Comparator
  
    - Comparator 是定义在Person的外部的, 此时我们的Person类的结构不需要有任何变化,然后我们另外定义一个比较器:如
    ```aidl
      public class Person{
           String name;
           int age
      }
      
      class PersonComparator implements Comparator { 
           public int compare(Person one, Person another) {
                int i = 0;
                i = one.name.compareTo(another.name); // 使用字符串的比较
                if(i == 0) { // 如果名字一样,比较年龄,返回比较年龄结果
                     return one.age - another.age;
                } else {
                     return i; // 名字不一样, 返回比较名字的结果.
                }
           }
      }
         Collections.sort( personList , new PersonComparator()) 可以对其排序

    ```  
    - 不需要修改源代码，另外实现一个比较器。

  

