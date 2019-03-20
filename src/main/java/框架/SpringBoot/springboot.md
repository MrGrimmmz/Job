###什么是springboot
   
   - 用来简化spring应用的初始搭建以及开发过程 使用特定的方式来进行配置（properties或yml文件）
   
   - 创建独立的spring引用程序 main方法运行
   - 嵌入的Tomcat 无需部署war文件
   - 简化maven配置
   - 自动配置spring添加对应功能
   - starter自动化配置
   
###@SpringBootConfiguration
- @Configuration
    - IoC容器的配置类
    
- @EnableAutoConfiguration
    - @EnableAutoConfiguration借助@Import的帮助，将所有符合自动配置条件的bean定义加载到IoC容器

- @ComponentScan
    - @ComponentScan的功能其实就是自动扫描并加载符合条件的组件（比如@Component和@Repository等）或者bean定义，最终将这些bean定义加载到IoC容器中。
    - 可以通过basePackages等属性来细粒度的定制@ComponentScan自动扫描的范围，如果不指定，则默认Spring框架实现会从声明@ComponentScan所在类的package进行扫描。
    
    

