###like
like 匹配/模糊匹配，会与 % 和 _ 结合使用。

- '%a'     //以a结尾的数据
- 'a%'     //以a开头的数据
- '%a%'    //含有a的数据
- "_ a _"    //三位且中间字母是a的
- '_a'     //两位且结尾字母是a的
- 'a_'     //两位且开头字母是a的

```aidl
SELECT * from runoob_tbl  WHERE runoob_author LIKE '%COM';
```

###in查询
where子句中用来指定要匹配值得清单的关键字，功能与or相似

叫in查询不是很合理 ，更合理的说法是 ：in其实和=类似，区别在于：=后面是一个值。in 后面可以是多个值。

```aidl
示例1：select * from role where name in("唐三")；即匹配姓名为“唐三”一行数据；
示例2：select * from role where name in("唐三","唐三藏")；即匹配姓名为“唐三”，“唐三藏”一行数据；
示例3：select * from role where name in("唐三","%行者%")，只匹配姓名为“唐三”一行数据；即in查询不支持模糊查询，如示例4
示例4：select * from role where name in("%行者%")，无匹配结果
```

###Mysql 连接的使用
JOIN 按照功能大致分为如下三类：
- INNER JOIN（内连接,或等值连接）：获取两个表中字段匹配关系的记录。
- LEFT JOIN（左连接）：获取左表所有记录，即使右表没有对应匹配的记录。
- RIGHT JOIN（右连接）： 与 LEFT JOIN 相反，用于获取右表所有记录，即使左表没有对应匹配的记录。

```aidl
SELECT a.runoob_id, a.runoob_author, b.runoob_count FROM runoob_tbl a INNER JOIN tcount_tbl b ON a.runoob_author = b.runoob_author;
```

