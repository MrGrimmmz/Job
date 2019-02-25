### epoll的底层结构
* epoll在linux内核中申请了一个简易的文件系统，把原先的一个select或者poll调用分成了3个部分：
调用epoll_create建立1个epoll对象（在epoll文件系统中给这个句柄分配资源）、调用epoll_ctl向epoll对象中添加这100万个连接的套接字、
调用epoll_wati收集发生事件的连接。这样，只需要在进程启动时建立1个epoll对象，并在需要的时候向它添加或删除连接就可以了，
因此，在实际收集事件时，epoll_wait的效率就会非常高，因为调用epoll_wait时并没有向它传递着100万个连接，内核也不需要去遍历全部的连接。
* 当某一个进程调用epoll_create方法时，Linux内核会创建一个eventpoll结构体，这个结构体中有两个成员于epoll的使用方式密切相关，如下所示：
```
 struct eventpoll{
     /*红黑树的跟节点，这棵树中存储着所有添加到epoll中的事件，也就是这个epoll监控的事件*/
     struct rb_root_rbr；
     //双向链表tdllist保存着将要通过epoll_wait放回给用户的、满足条件的事件
     struct  list_head_rdllist;
}
```
* 每一个epoll对象都有一个独立的eventpoll结构体，这个结构体会在内核空间中创造独立的内存，用于存储使用epoll_ctl方法想epoll对象中添加进来的事件。
这些事件都会挂到rbr红黑树中，这样，重复添加的事件就可以通过红黑树而高效标示出来（epoll_ctl方法会很快）。
* ![](https://img-blog.csdn.net/20140501094548609)
* ![](https://images.cnitblog.com/blog/444582/201308/03152919-51d2e2ac3a51422bace3e4b0009225e1.jpg)
* 所有添加到epoll中的事件都会与设备（如网卡）驱动程序建立回调关系，也就是说，相应的事件发生时会调用这里的回调方法。
这个回调方法在内核中叫做ep_epoll_callback，它会把这样的事件放到上面的rdllist双向链表中。在epoll中，对于每一个事件都会建立一个epitem结构体。
这里包含每一个事件对应着的信息。
* 当调用epoll_wait检查是否有发生事件的连接时，只是检查eventpoll对象中的rdllist双向链表是否有epitem元素而已，如果rdllist链表不为空，
则把这里的事件复制到用户态内存中，同时将时间数量返回给用户，因此，epoll_wait的效率非常高，epoll_ctl在向epoll对象中添加、修改。删除事件时，
从rbr红黑树中查找事件也非常快，也就是说,epoll是非常高效的，它可以轻易地处理百万级的并发连接。