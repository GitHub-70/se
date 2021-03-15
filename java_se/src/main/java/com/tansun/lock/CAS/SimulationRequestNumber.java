package com.tansun.lock.CAS;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 模拟100个用户，每个用户访问10次，最后统计总访问量
 */
public class SimulationRequestNumber {

    // 模拟网站总访问量
    private static Integer count = 0;
    // 用户数
    private static Integer userNum = 100;

    // 模拟访问网站的方法
    public static void request() throws InterruptedException {
        // 模拟访问网站耗时5毫秒
        TimeUnit.MILLISECONDS.sleep(5);
        /**
         *  Q:分析count++非原子操作
         *      count++编译后，由3步指令执行
         *      1.获取count的值，记做A：A=count
         *      2.将A的值+1，记做B：B=A+1
         *      3.将B值赋值给count coun=B
         */
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        // 记录当前时间
        long startTime = System.currentTimeMillis();

        // 线程数量
        Integer threadSize = 100;
        // 设定初始值大小为threadSize   类似于计数器功能
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);

        // 模拟100个用户来访问网站，每个用户访问10次
        for (int i = 0; i < userNum; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 模拟每个用户访问 10次
                    try {
                        for (int j = 0; j < 10; j++) {
                            request();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();// 每个用户访问完后递减
                    }
                }
            }).start();
        }
        // 怎么保证100个线程执行 结束之后,在执行后面代码 利用CountDownLatch
        countDownLatch.await();// 一直等到每个用户访问完后，即为0，才执行下面代码
        long endTime = System.currentTimeMillis();
        long doTime = endTime - startTime;
        System.out.println("耗时：" + doTime + "毫秒 ,访问总量：" + count);
    }

}
