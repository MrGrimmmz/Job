###MYSQL分页limit速度太慢优化方法
假设有如下SQL语句：
```
SELECT * FROM table1 LIMIT offset, rows
```
这是一条典型的LIMIT语句，常见的使用场景是，某些查询返回的内容特别多，而客户端处理能力有限，希望每次只取一部分结果进行处理。

上述SQL语句的实现机制是:

从“table”表中读取offset+rows行记录
抛弃前面的offset行记录，返回后面的rows行记录作为最终结果。
这种实现机制存在一个弊端：虽然只需要返回rows行记录，但却必须先访问offset行不会用到的记录。对一张数据量很大的表进行查询时，offset值可能非常大，此时limit语句的效率就非常低了。

1）如果id连续
假定我们的id是里连续的，那么用id>500w即可，只需要0.007秒，效率非常高
```
select id,name from test where id>5000000 limit 0,100
```

2）如果id不连续
事实是id一般不是连续的，比如我们突然删除（或者逻辑删除）了其中的几百条，那么id就断了，这种情况下就需要我们自己来计算id
```$xslt
select id,name from test where id>=(select id from test limit 5000000,1) limit 100
```

####limit 分页优化方法
1.子查询优化法 
先找出第一条数据，然后大于等于这条数据的id就是要获取的数据 

缺点：数据必须是连续的，可以说不能有where条件，where条件会筛选数据，导致数据失去连续性

2.倒排表优化法 
倒排表法类似建立索引，用一张表来维护页数，然后通过高效的连接得到数据

缺点：只适合数据数固定的情况，数据不能删除，维护页表困难

3.反向查找优化法 
当偏移超过一半记录数的时候，先用排序，这样偏移就反转了

缺点：order by优化比较麻烦，要增加索引，索引影响数据的修改效率，并且要知道总记录数 
，偏移大于数据的一半
