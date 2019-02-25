package Java基础.多线程打印abc;

import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程交替打印abc10次
 * @Author ifcc
 * @Date 2018-04-16
 * @School SouthEast University
 * @Verstion 1.0
 **/
public class Solution {
    public static void main(String[] args){
        /*new PrintABC("A").start();
        new PrintABC("B").start();
        new PrintABC("C").start();*/
        ExecutorService service = Executors.newFixedThreadPool(3);

        service.execute(new ThreadA());
        service.execute(new ThreadB());
        service.execute(new ThreadC());

        service.shutdown();
    }

    public static class PrintABC extends Thread{

        private static int currentCount = 0;

        public PrintABC(String name) {
            this.setName(name);
        }

        @Override
        public void run() {
            while (currentCount < 30) {
                switch (currentCount % 3) {
                    case 0:
                        if ("A".equals(getName())) {
                            printAndIncrease();
                        }
                        break;
                    case 1:
                        if ("B".equals(getName())) {
                            printAndIncrease();
                        }
                        break;
                    case 2:
                        if ("C".equals(getName())) {
                            printAndIncrease();
                        }
                        break;
                }
            }

        }

        private void printAndIncrease() {
            print();
            increase();
        }

        private void print() {
            System.out.println(getName());
            if ("C".equals(getName())) {
                System.out.println();
            }
        }

        private void increase() {
            currentCount++;
        }
    }
    private static ReentrantLock lock=new ReentrantLock();
    private static Condition conditionA=lock.newCondition();
    private static Condition conditionB=lock.newCondition();
    private static Condition conditionC=lock.newCondition();
    private static String currentThreadName="A";
    public static class ThreadA implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<10;i++){
                lock.lock();
                while (currentThreadName!="A"){
                    try {
                        conditionA.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("A");
                currentThreadName="B";
                conditionB.signal();
                lock.unlock();
            }
        }
    }

    public static class ThreadB implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<10;i++){
                lock.lock();
                while (currentThreadName!="B"){
                    try {
                        conditionB.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("B");
                currentThreadName="C";
                conditionC.signal();
                lock.unlock();
            }
        }
    }

    public static class ThreadC implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<10;i++){
                lock.lock();
                while (currentThreadName!="C"){
                    try {
                        conditionC.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("C");
                currentThreadName="A";
                conditionA.signal();
                lock.unlock();
            }
        }
    }

    private static AtomicInteger sycValue = new AtomicInteger(0);
    private static int i=0;
    private static final int MAX_SYC_VALUE = 3 * 10;

    private static class RunnableA implements Runnable {

        public void run() {

            while (sycValue.get() < MAX_SYC_VALUE) {
                if (sycValue.get() % 3 == 0) {
                    System.out.println(String.format("第%d遍",
                            sycValue.get() / 3 + 1));
                    System.out.println("A");
//                    sycValue.getAndIncrement();
                    sycValue.getAndIncrement();
                }
            }

        }
    }
    private static class RunnableB implements Runnable {

        public void run() {

            while (sycValue.get() < MAX_SYC_VALUE) {
                if (sycValue.get() % 3 == 1) {
                    System.out.println("B");
                    sycValue.getAndIncrement();

                }
            }

        }
    }
    private static class RunnableC implements Runnable {

        public void run() {

            while (sycValue.get() < MAX_SYC_VALUE) {
                if (sycValue.get() % 3 == 2) {
                    System.out.println("C");
                    System.out.println();
                    sycValue.getAndIncrement();
                }
            }

        }
    }

}
