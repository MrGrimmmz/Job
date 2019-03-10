package 并发编程;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author LIFAN
 * 2019/3/8 18:03
 * ReentrantReadWriteLock是ReadWriteLock的实现类。
 */
public class ReadWriteLock {
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args)  {
        final ReadWriteLock readWriteLock = new ReadWriteLock();

        new Thread(){
            public void run() {
                readWriteLock.get(Thread.currentThread());
            }
        }.start();

        new Thread(){
            public void run() {
                readWriteLock.get(Thread.currentThread());
            }
        }.start();

    }

    public void get(Thread thread) {
        rwl.readLock().lock();
        try {
            long start = System.currentTimeMillis();

            while(System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName()+"正在进行读操作");
            }
            System.out.println(thread.getName()+"读操作完毕");
        } finally {
            rwl.readLock().unlock();
        }
    }
}
