package 并发编程;

import java.util.concurrent.Semaphore;

/**
 * @author LIFAN
 * 2019/3/8 16:41
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        int N = 8;            //工人数
        Semaphore semaphore = new Semaphore(5); //机器数目
        for(int i=0;i<N;i++)
            new Worker(i,semaphore).start();
    }

    static class Worker extends Thread{
        private int num;
        private Semaphore semaphore;
        public Worker(int num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                //如果新线程进入后不能够获得许可则会阻塞，直到获得许可然后再往下执行
                //获得到使用资源的能力，并发执行的线程数取决于semaphore的个数配置 ，此配置数也就是可用资源的数目
                System.out.println("工人"+this.num+"占用一个机器在生产...");
                Thread.sleep(2000);
                System.out.println("工人"+this.num+"释放出机器");
                semaphore.release();    //释放许可
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
