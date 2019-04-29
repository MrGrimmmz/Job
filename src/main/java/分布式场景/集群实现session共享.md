###集群下实现Session共享的几种方案
1. 请求精确定位(session绑定)
    - 基于IP地址的Hash策略，将同一用户的请求都集中在一台服务器上，这台服务器上保存了该用户的Session信息。
    - 缺点：单点部署发生宕机时，Session丢失。

2. Session复制共享
    - 比如可以用Tomcat自带的插件进行Session同步，使得多台应用服务器之间自动同步Session，保持一致。
    如果一台发生故障，负载均衡会遍历寻找可用节点，Session也不会丢失。
    - 缺点：必须是Tomcat和Tomcat之间，Session的复制也会消耗系统的性能，在应用集群达到数千台的时候，就会出现瓶颈，每台都需要备份session，出现内存不够用的情况。
    使得同步给成员时容易造成内网流量瓶颈。
 
3. 基于cache DB缓存的Session共享（推荐，Spring-Session也是同样的原理，同自定义的JRedis一起配置可以实现目的）
    - 使用Redis存取Session信息，应用服务器发生故障时，当Session不在内存中时就会去CacheDB中查找
    （要求Redis支持持久化），找到则复制到本机，实现Session共享和高可用。

4. Sesion数据集中存储
    - 另外搭建session服务器，与应用服务器进行 通信
        
###session放入redis

##[参考](https://www.cnblogs.com/lingshao/p/5580287.html)