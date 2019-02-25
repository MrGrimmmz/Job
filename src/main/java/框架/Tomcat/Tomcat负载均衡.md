###Tomcat负载均衡
* Tomcat的连接器协议有两种
    * http
    * ajp
* Tomcat的http连接器（三种）
    * 基于Java的http/1.1连接器
    * 基于java的高性能NIO HTTP/1.1连接器
    * 基于C/C++研发的Native APR HTTP/1.1连接器
* mod_jk
    * 支持ajp
* mod_proxy
    * 支持http/https/ajp
    
* LAMT
    * Apache（mod_jk,ajp）+ Tomcat(ajp connector)
    * Apache (mod_proxy,(http,https,ajp)) + Tomcat(http,https.ajp)
* LNMT
    * Nginx + Tomcat(http,https)