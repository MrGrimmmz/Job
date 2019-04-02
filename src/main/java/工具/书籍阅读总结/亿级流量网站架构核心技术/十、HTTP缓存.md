###HTTP缓存
####首次访问
* Last-Modified: 表示文档的最后修改时间，当去服务器验证时会用到这个时间
* Expires: http/1.0规范定义，表示文档在浏览器中的过期时间，当缓存内容时间超过这个时间，则需要重新去服务器获取新的内容
* Cache-Control: http/1.1规范定义，表示浏览器缓存控制，Cache-Control优先级高于Expires
####from cache
* 当我们按F5键刷新、按“Ctrl+F5”键强制刷新、在地址栏输入地址刷新时，都会去服务器端验证内容是否发生了变更。
那么不去服务器端验证的情况是：
    * 从A页面跳转到A页面或者从A页面跳转到B页面时。
    * 通过浏览器历史记录进行前进后退时。
####Age
* 一般用于缓存代理层（如CDN），表示此内容在缓存代理层从创建到现在生存了多长时间
####Vary
* 一般用于缓存代理层（如CDN），如响应头列表，如“Vary:Accept-Encoding”、“Vary:User-Agent”
主要用于通知缓存服务器对于相同的URL有着不同版本的响应，如压缩版本和非压缩版本。
####Via
* 一般用于代理层（如CDN），表示访问到最终内容前经过了哪些代理层，用的什么协议，代理层是否缓存命中等。
####ETag
* ETag被定义为“被请求变量的实体值”，可以理解为文档内容的摘要，可用来判断页面内容是否已经被修改过了
用于发送到服务器端进行内容变更验证的，而Catch-Control是用于控制缓存时间的（浏览器、代理层）
####Cache-Control总结
* public: 响应头，可共享缓存（客户端和代理服务器都可以缓存），响应可以被缓存
* private: 响应头，可私有缓存（客户端可以被缓存，代理服务器不能缓存），比如用户私有内容，不能共享
* no-cache: 请求头使用时表示是需要回源验证；响应头使用时表示允许缓存者缓存响应，但是，使用时必须回源验证
* no-store: 请求和响应禁止缓存
* max-age: 缓存的保鲜期和Expires类似
* s-maxage: 与max-age的区别在于其仅用于共享缓存（如缓存代理服务器）
* max-stale: 缓存的最大陈旧时间，如果缓存不新鲜但是还在该最大陈旧时间内，则可以返回陈旧内容
* min-fresh: 缓存的最小新鲜期
* must-revalidate: 当缓存过了新鲜期后，必须回源重新验证
* proxy-revalidate: 与must-revalidate类似，但是只对缓存代理服务器有效
* stale-while-revalidate: 请求时，表示在指定时间内可以先返回陈旧的内容，后台进行重新验证（如异步验证）
* stale-if-error: 请求时，表示在指定时间内，当重新验证请求响应状态码为500、502、503、504时，可以使用陈旧内容
* only-if-cached: 请求时，使用该头表示只从缓存获取响应，如果没有，则504 Gateway Timeout
###Nginx HTTP缓存设置
####expires
* 使用Nginx作为静态资源服务器，可以使用expires进行缓存控制
####if-modified-since
* 此指令用于指定Nginx对服务器端的Last-Modified和浏览器端的if-modified-since时间进行比较，
默认的"if_modified_since exact"表示精确匹配，也可以使用"if_modified_since _before"表示只要文件的
最后修改时间早于或者等于浏览器端的if-modified-since时间，就返回304
####nginx proxy_pass
