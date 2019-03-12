package 并发编程.tools部分;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LIFAN
 * 2019/3/8 16:47
 */
public class ExchangerTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        final Exchanger exchanger = new Exchanger();
        executor.execute(new Runnable() {
            String data1 = "Ling";

            @Override
            public void run() {
                doExchangeWork(data1, exchanger);
            }
        });

        executor.execute(new Runnable() {
            String data2 = "huhx";

            @Override
            public void run() {
                doExchangeWork(data2, exchanger);
            }
        });
        executor.shutdown(); //把线程池停掉 释放资源
    }

    private static void doExchangeWork(String data1, Exchanger exchanger) {
        try {
            System.out.println(Thread.currentThread().getName() + "正在把数据 " + data1 + " 交换出去");
            Thread.sleep((long) (Math.random() * 1000));

            String data2 = (String) exchanger.exchange(data1);
            System.out.println(Thread.currentThread().getName() + "交换数据 到  " + data2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}