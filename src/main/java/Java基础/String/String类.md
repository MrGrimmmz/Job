###String类
- 1）String类是final类，也即意味着String类不能被继承，并且它的成员方法都默认为final方法。在Java中，被final修饰的类是不允许被继承的，并且该类中的成员方法都默认为final方法。

- 2）上面列举出了String类中所有的成员属性，从上面可以看出String类其实是通过char数组来保存字符串的。
- 3）无论是substring、concat还是replace操作都不是在原有的字符串上进行的，而是重新生成了一个新的字符串对象。也就是说进行这些操作后，最原始的字符串并没有被改变。

- 在这里要永远记住一点：“String对象一旦被创建就是固定不变的了，对String对象的任何改变都不影响到原对象，相关的任何change操作都会生成新的对象”。

###Java String 和 new String()的区别
- (1) String str1 = "abcd"的实现过程：
    - 首先栈区创建str引用，然后在String池（独立于栈和堆而存在，存储不可变量）中寻找其指向的内容为"abcd"的对象，如果String池中没有，则创建一个，然后str指向String池中的对象，如果有，则直接将str1指向"abcd"；，如果后来又定义了字符串变量 str2 = "abcd",则直接将str2引用指向String池中已经存在的“abcd”，不再重新创建对象；当str1进行了赋值（str1=“abc”），则str1将不再指向"abcd"，而是重新指String池中的"abc"，此时如果定义String str3 = "abc",进行str1 == str3操作，返回值为true，因为他们的值一样，地址一样，
    
    - 单独使用""引号创建的字符串都是常量,编译期就已经确定存储到String Pool中

    - "aa" + "aa"创建的也是常量
    
- (2) String str3 = new String("abcd")的实现过程：
    - 直接在堆中创建对象。如果后来又有String str4 = new String("abcd")，str4不会指向之前的对象，而是重新创建一个对象并指向它，所以如果此时进行str3==str4返回值是false，因为两个对象的地址不一样，如果是str3.equals(str4)，返回true,因为内容相同。
    
    - 使用new String("")创建的对象会存储到heap中,是运行期新创建的；
    
- 
