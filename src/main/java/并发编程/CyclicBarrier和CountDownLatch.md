###CyclicBarrier和CountDownLatch的异同
* CyclicBarrier从字面理解是指循环屏障，它可以协同多个线程，让多个线程在这个屏障前等待，
直到所有线程都达到了这个屏障时，再一起继续执行后面的动作
* CountDownLatch是在多个线程都进行了latch.countDown()后才会触发事件，唤醒await()在latch上的
线程，而执行countDown()的线程，执行完countDown()后会继续自己线程的工作；CyclicBarrier是一个
栅栏，用于同步所有调用await()方法的线程，线程执行了await()方法之后并不会执行之后的代码，而
只有当执行await()方法的线程数等于指定的parties之后，这些执行了await()方法的线程才会同时运行
* CountDownLatch不能循环使用，计数器减为0就减为0了，不能被重置；CyclicBarrier提供了reset()方法，支持循环使用
* CountDownLatch当调用countDown()方法的线程数等于指定的数量之后，可以唤起多条线程的任务；CyclicBarrier当
执行await()方法的线程等于指定的数量之后，只能唤起一个BarrierAction