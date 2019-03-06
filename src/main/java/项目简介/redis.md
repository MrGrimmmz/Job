##redis分布式锁
首先，为了确保分布式锁可用，我们至少要确保锁的实现同时满足以下四个条件：

1. 互斥性。在任意时刻，只有一个客户端能持有锁。
2. 不会发生死锁。即使有一个客户端在持有锁的期间崩溃而没有主动解锁，也能保证后续其他客户端能加锁。
3. 具有容错性。只要大部分的Redis节点正常运行，客户端就可以加锁和解锁。
4. 解铃还须系铃人。加锁和解锁必须是同一个客户端，客户端自己不能把别人加的锁给解了。

###保证设置锁和设置超期时间的原子性
```$xslt
if redis.call('setnx',KEYS[1],ARGV[1]) == 1 
then  
    return redis.call('expire',KEYS[1],ARGV[2])  
else 
    return 0 
end
```

###防止错误删除锁
- 保证加锁和删除锁是同一个线程
- 使用lua脚本
```$xslt
//key表示锁名称，argv表示请求ID
if redis.call("get", KEYS[1]) == ARGV[1]
then
    return redis.call("del", KEYS[1])
else
    return 0
end
```

##redis赞踩功能
使用集合的sadd和srem来完成时，首先我们需要创建两个集合，一个赞集合，一个踩集合

- 点赞时：向赞集合添加该用户，删除踩集合中的该用户
- 踩时：向踩集合添加该用户，删除赞集合中的该用户

判断是否赞踩
- SISMEMBER key member 
- 判断 member 元素是否是集合 key 的成员

##关注，粉丝，浏览量
添加关注
- ZADD key score1 member1 [score2 member2] 
- 向有序集合添加一个或多个成员，或者更新已存在成员的分数

```$xslt
        Jedis jedis = jedisAdapter.getJedis();
        Transaction tx = jedisAdapter.multi(jedis);
        // 实体的粉丝增加当前用户
        tx.zadd(followerKey, date.getTime(), String.valueOf(userId));
        // 当前用户对这类实体关注+1
        tx.zadd(followeeKey, date.getTime(), String.valueOf(entityId));
        List<Object> ret = jedisAdapter.exec(tx, jedis);
```
取消关注
- ZREM key member [member ...] 
- 移除有序集合中的一个或多个成员

```$xslt
        Jedis jedis = jedisAdapter.getJedis();
        Transaction tx = jedisAdapter.multi(jedis);
        // 实体的粉丝移除当前用户
        tx.zrem(followerKey, String.valueOf(userId));
        // 当前用户对这类实体关注-1
        tx.zrem(followeeKey, String.valueOf(entityId));
        List<Object> ret = jedisAdapter.exec(tx, jedis);
```

获取关注或粉丝
- ZREVRANGE key start stop [WITHSCORES] 
- 返回有序集中指定区间内的成员，通过索引，分数从高到底

判断是否是粉丝
- ZSCORE key member 
- 返回有序集中，成员的分数值

##浏览量
字符串
- SET key value 
- 设置指定 key 的值
- GET key 
- 获取指定 key 的值。

##redis异步消息队列
![](redis异步队列.png)

- EventProducer将事件推送到消息队列中：lpush 
- EventConsumer监听队列，只要监测到有事件到达，使用brpop阻塞的从列表中取出消息，交给对应的Handler进行处理。
