##session 与 cookie 区别
- cookie是 Web 服务器发送给浏览器的一块信息。浏览器会在本地文件中给每一个Web服务器存储cookie。以后浏览器在给特定的Web服务器发请求的时候，同时会发送所有为该服务器存储的cookie。

- Session 是存放在服务器端的，类似于Session结构来存放用户数据，当浏览器 第一次发送请求时，
服务器自动生成了一个Session和一个Session ID用来唯一标识这个Session，并将其通过响应发送到浏览器。
当浏览器第二次发送请求，会将前一次服务器响应中的Session ID放在请求中一并发送到服务器上，
服务器从请求中提取出Session ID，并和保存的所有Session ID进行对比，找到这个用户对应的Session。

- Session的客户端实现形式（即Session ID的保存方法）
    - [1] 使用Cookie来保存，这是最常见的方法，服务器通过设置Cookie的方式将Session ID发送到浏览器。
      
    - [2] 使用URL附加信息的方式，也就是像我们经常看到JSP网站会有aaa.jsp?JSESSIONID=*一样的。
      
    - [3] 第三种方式是在页面表单里面增加隐藏域，这种方式实际上和第二种方式一样，只不过前者通过GET方式发送数据，后者使用POST方式发送数据。但是明显后者比较麻烦。

* session和cookie 的区别：
    - 1、Session是在服务端保存的一个数据结构，用来跟踪用户的状态，这个数据可以保存在集群、数据库、文件中；Cookie是客户端保存用户信息的一种机制，用来记录用户的一些信息，也是实现Session的一种方式。
    
    - 2、cookie不是很安全，别人可以分析存放在本地的cookie并进行cookie欺骗，考虑到安全应当使用session。
      
    - 3、session会在一定时间内保存在服务器上。当访问增多，会比较占用你服务器的性能，考虑到减轻服务器性能方面，应当使用cookie。
      
    - 4、单个cookie保存的数据不能超过4K，很多浏览器都限制一个站点最多保存20个cookie。
      
    - 5、可以考虑将登陆信息等重要信息存放为session，其他信息如果需要保留，可以放在cookie中。

- 联系
    - session需要借助cookie才能正常工作，如果客户端完全禁止cookie,session将失效，因为session是由应用服务器维持的一个服务端的存储空间，用户在连接服务器时，会由服务器生成唯一的sesssionid，用该sessionid为标识来存取服务端的session空间。而sessionid存储在cookie中，用户提交页面时会将这个sessionid提交到服务端，来存取session数据.这一过程是不用开发人员干预的，所以一旦客户端禁用cookie,那么session也会失效；
