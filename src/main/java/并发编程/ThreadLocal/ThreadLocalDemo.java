package 并发编程.ThreadLocal;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author LIFAN
 * 2019/4/1 13:48
 */
public class ThreadLocalDemo {
    // ThreadLocal一般权限声明为private static
    private static final ThreadLocal<Person> aPerson = new ThreadLocal<Person>() {

        // 默认返回null，在此override初始化方法
        @Override
        protected Person initialValue() {
            return new Person("A Baby", 0);
        }
    };

    Random rand = new Random();

    // 辅助演示的javabean
    static class Person {
        String name;

        int age;

        Person(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {

            return this.name + "-" + this.age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    }

    // 辅助演示的Runnable实现类
    class MyTask implements Runnable {

        private boolean needSet;

        MyTask (boolean needSet) {
            this.needSet = needSet;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Start......");
            // 休眠3s
            try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {}

            if (needSet)
                // 向ThreadLocal设置一个值
                aPerson.set(new Person(Thread.currentThread().getName(), rand.nextInt(60)));

            System.out.println("Thread Name: " + Thread.currentThread().getName()
                    + " This thread's ThreadLocal: " + aPerson.get().toString());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalDemo foo = new ThreadLocalDemo();
        Thread t1 = new Thread(foo.new MyTask(true), "Henry");
        Thread t2 = new Thread(foo.new MyTask(true), "Cevin");
        // 该线程不设置ThreadLocal，直接使用初始值
        Thread t3 = new Thread(foo.new MyTask(false), "Jessica");
        t1.start();
        t2.start();
        t3.start();
    }
}