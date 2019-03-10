package 并发编程;

import java.util.concurrent.CountDownLatch;

/**
 * @author LIFAN
 * 2019/3/8 15:39
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(){
            public void run() {
                try {
                    System.out.println("子线程1："+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程1："+Thread.currentThread().getName()+"执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            public void run() {
                try {
                    System.out.println("子线程2："+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程2："+Thread.currentThread().getName()+"执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        try {
            System.out.println("主线程：等待2个子线程执行完毕...");
            latch.await();
            System.out.println("主线程：2个子线程已经执行完毕");
            System.out.println("主线程：继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
