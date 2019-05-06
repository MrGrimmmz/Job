###注解
- @Autowired默认按类型装配
- @Autowired @Qualifier("personDaoBean") 存在多个实例配合使用

- @Resource默认按名称装配，用@Resource进行依赖注入，它先会根据指定的name属性去Spring容器
中寻找与该名称匹配的对象，例如：@Resource(name="userDao")，如果没有找到该名称，则会按照类型去寻找，

- @Qualifier注解，默认按名称装配， 但是注意是 类名。

- <context:annotation-config>处理@autowired之类的注解（共有四类）前提是注解作用的类已经被注册到spring容器里
（bean id="" class=""） 
- <context:component-scan>除了包含<context:annotation-config>的作用外，还能自动扫描和注册base-package下有
@component之类注解的类，将其作为bean注册到spring容器里
- 所以配置文件如果有<context:component-scan>就不需要<context:annotation-config>了。


