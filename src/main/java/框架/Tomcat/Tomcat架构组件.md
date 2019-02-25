###Tomcat的配置层次
####server.xml
```
    <server>
        <service>
            <connector/>
            <engine>
                <host>
                    <context>
                    </context>
                </host>
            </engine>
        </service>
    </server>
```
* 顶级组件  位于整个配置的顶层
* 容器类  可以包含其他组件的组件
* 连接器组件  连接用户请求至Tomcat
* 被嵌套类的组件  位于一个容器当中，不能包含其他组件
#####容器类
* engine：核心容器 catalina引擎，负责通过connector接收用户请求
* host：类似于httpd中的虚拟主机，支持基于FQDN的虚拟主机
* context：最内层的容器类组件，一个context代表了一个web应用，配置context的主要目的是指定对应的webapp的根目录
#####服务
* service  将连接器关联至engine，因此，一个service内部可以有多个connector，但只能有一个engine
#####顶级组件
* server  表示一个运行于JVM中的Tomcat实例
#####嵌套类组件
* valve  拦截请求，并在将其转至对应的webapp之前进行某种处理操作，可以用于任何容器中
* logger  日志记录器，用于记录组件，内部的状态信息，可以用于除context之外的任何容器中
* realm  可以用于任何容器类的组件中，关联一个用户的认证库，实现认证和授权
    * UserDatabaseRealm：使用JNDI自定义的用户认证库
    * MemoryRealm：tomcat-users.xml中
    * JDBCRealm: 基于JDBC连接至数据库中查找用户
###Tomcat的配置文件
####server.xml
####context.xml
* 为部署于此Tomcat实例上的所有web应用程序提供的默认配置文件，每个webapp都可以使用独有的
context.xml，通常放置于webapp目录的META-INF子目录中，常用于定义回话管理器，Realm以及JDBC等
####web.xml
* 为部署于此Tomcat实例上的所有应用程序提供默认部署描述符，通常用于为webapp提供基本的servlet
定义和MIME映射表等
####catalina.policy
* 当基于-security选项启动Tomcat实例时会读取此配置文件，此文件是JAVA的安全策略配置文件，
配置访问codebase或某此Java类的权限
####catalina.properties
* Java属性定义文件，设定类加载器路径，安全包列表和一些调整性能的参数信息
####logging.properties
* 定义日志相关的配置信息，如日志级别、文件路径等
###webapp体系架构
* webapp有特定的组织格式，是一种层次型目录结构；通常包含了servlet代码文件、jsp页面文件、
类文件、部署描述文件等等。
* /: web应用程序的根目录
* /WEB-INF: 此webapp的私有资源目录，通常web.xml和context.xml均放置于此目录
* /WEB-INF/classes: 此webapp自有的类；
* /WEB-INF/lib: 此webapp自有能够被打包为jar格式的类，即所依赖的jar包
###webapp的归档格式
* EJB类归档的扩展名为.jar
* web应用程序的归档扩展名为.war
* 资源适配器的扩展名为.rar
* 企业级应用程序的扩展名为.ear
* web服务的扩展名为.ear或.war
###Tomcat应用程序部署
* 部署是指将webapp及其所依赖类库等装载进Tomcat实例上，以便接受用户请求
* 部署方式：
    * 静态方式：在Tomcat启动之前进行webapp部署
    * 动态方式：在打断Tomcat运行的前提下，通过Tomcat manager或其它的命令行工具进行的部署
* 部署操作：
    * Deploy：将webapp的源文件放置于目标目录，配置Tomcat服务器能够基于某context路径访问
    此webapp，并将其特有的类由类加载器进行装载等
    * Redeploy：重新部署，主要用于升级时
    * Undeploy：取消部署，停止应用程序并从Tomcat实例上移除其部分文件和部署名
    * stop：停止
    * start：将停止的webapp启动起来
###
