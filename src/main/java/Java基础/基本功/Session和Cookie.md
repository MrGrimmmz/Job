##session 与 cookie 区别
cookie 是 Web 服务器发送给浏览器的一块信息。浏览器会在本地文件中给每一个 Web 服务
器存储 cookie。以后浏览器在给特定的 Web 服务器发请求的时候，同时会发送所有为该服
务器存储的 cookie。
* session 和 cookie 的区别：
无论客户端浏览器做怎么样的设置，session都应该能正常工作。客户端可以选择禁用 cookie，
但是， session 仍然是能够工作的，因为客户端无法禁用服务端的 session。
