###Spring单例模式及线程安全
- 默认scope的值是singleton，即产生的对象是单例的
```$xslt
<bean id="helloIoc" scope="singleton" class="com.ys.ioc.HelloIoc" ></bean>
```
- scope=“prototype”,多例模式，并且spring容器启动的时候并不会创建对象，而是在得到 bean 的时候才会创建对象
```$xslt
<bean id="helloIoc" scope="prototype" class="com.ys.ioc.HelloIoc" ></bean>
```

- 总结：
    - 在单例模式下，启动 spring 容器，便会创建对象；
    - 在多例模式下，启动容器并不会创建对象，获得 bean 的时候才会创建对象
  


###Spring 容器创建对象的时机
- 第一种：默认情况下，启动 spring 容器便创建对象（遇到bean便创建对象）
- 第二种：在spring的配置文件bean中有一个属性 lazy-init="default/true/false"
    - ①、如果lazy-init为"default/false"在启动spring容器时创建对象（默认情况）
    - ②、如果lazy-init为"true",在context.getBean时才要创建对象