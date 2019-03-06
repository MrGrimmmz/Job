###三次握手
是指建立一个TCP连接时，需要客户端和服务端总共发送3个包以确认连接的建立。在socket编程中，这一过程由客户端执行connect来触发

![](三次握手.png)

（1）第一次握手：Client将标志位SYN置为1，随机产生一个值seq=J，并将该数据包发送给Server，Client进入SYN_SENT状态，等待Server确认。

（2）第二次握手：Server收到数据包后由标志位SYN=1知道Client请求建立连接，Server将标志位SYN和ACK都置为1，ack=J+1，随机产生一个值seq=K，并将该数据包发送给Client以确认连接请求，Server进入SYN_RCVD状态。

（3）第三次握手：Client收到确认后，检查ack是否为J+1，ACK是否为1，如果正确则将标志位ACK置为1，ack=K+1，并将该数据包发送给Server，Server检查ack是否为K+1，ACK是否为1，如果正确则连接建立成功，Client和Server进入ESTABLISHED状态，完成三次握手，随后Client与Server之间可以开始传输数据了。

- 客户端：发送J
- 服务端：发送K， 确认J+1
- 客户端：发送J+1（1000），确认K+1（2000）

###四次挥手
是指断开一个TCP连接时，需要客户端和服务端总共发送4个包以确认连接的断开。在socket编程中，这一过程由客户端或服务端任一方执行close来触发

- 一方主动关闭，另一方被动关闭的情况

![](四次挥手.png)

（1）第一次挥手：Client发送一个FIN，用来关闭Client到Server的数据传送，Client进入FIN_WAIT_1状态。

（2）第二次挥手：Server收到FIN后，发送一个ACK给Client，确认序号为收到序号+1（与SYN相同，一个FIN占用一个序号），Server进入CLOSE_WAIT状态。

（3）第三次挥手：Server发送一个FIN，用来关闭Server到Client的数据传送，Server进入LAST_ACK状态。

（4）第四次挥手：Client收到FIN后，Client进入TIME_WAIT状态，接着发送一个ACK给Server，确认序号为收到序号+1，Server进入CLOSED状态，完成四次挥手。

- 同时发起主动关闭

![](四次挥手2.png)


###为什么建立连接是三次握手，而关闭连接却是四次挥手呢？

- 三次握手：主要目的防止在网络发生延迟或者丢包的情况下浪费资源。
- 为什么两次握手不行：两次握手可能因为丢包而出现死锁，假设在两次握手场景中，C向S发送请求，S收到并发送确认请求给C，这时候S认为连接已经建立，并开始发送数据给C，但是那个确认请求丢包了，C不认为请求建立了，C当然会拒绝接受S发送来的数据，并且再去请求连接。这样，一个资源就死锁了


- 为什么四次挥手，因为tcp是全双工模式，接收到FIN时意味将没有数据再发来，但是还是可以继续发送数据