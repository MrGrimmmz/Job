####Junit
* 单元测试框架
* 重要注解介绍
* > @BeforeClass和@AfterClass
    * 在一个类中只可以出现一次
    * 必须声明为public static
    * 在类中只运行一次 
    * 所有标识为@AfterClass的方法都一定会被执行，即使在标识为@BeforeClass的方法抛出异常的的情况下也一样会。
* > @Before和@After
    * 在一个类中可以出现多次，即可以在多个方法的声明前加上这两个Annotation标签，执行顺序不确定
    * 在每个测试方法之前或者之后都会运行一次
    * 必须声明为public 并且非static
    * 所有标识为@After 的方法都一定会被执行，即使在标识为 @Before 或者 @Test 的方法抛出异常的的情况下也一样会。
* > @Ignore
    * 对包含测试类的类或@Test注解方法使用@Ignore注解将使被注解的类或方法不会被当做测试执行
* > 一个JUnit4的单元测试用例执行顺序为：
   @BeforeClass -> @Before -> @Test -> @After -> @AfterClass;
* > 每一个测试方法的调用顺序为：
   @Before -> @Test -> @After;
####Junit和Spring的整合
* 注解
    * @RunWith(SpringJUnit4ClassRunner.class)
    * @ContextConfiguration(locations="classpath:applicationContext.xml")