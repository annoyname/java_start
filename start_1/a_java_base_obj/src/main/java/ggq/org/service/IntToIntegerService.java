package ggq.org.service;

import ggq.org.util.InstanceUtil;
import ggq.org.vo.IntNumberVo;
import ggq.org.vo.PersonVo;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 提供关于 int 和 Integer 相关的操作
 * @author ggq Date: 2018-12-18 Time: 16:03
 * @version $Id$
 */
public class IntToIntegerService {

    // 构建需要的线程开启线程池
    private static final ExecutorService executorService =
        Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
    
    /**
     * int 和 Integer 之间相互转化
     *
     * ! 结果
     * 数字:0
     * 1:false
     * 2:true
     * 3:true
     * 4:true
     * 数字:128
     * 1:false
     * 2:false
     * 3:true
     * 4:true
     *
     */
    public void intToInteger(int count) {
        PersonVo personVo = InstanceUtil.getPersonInstance();

        int number = count;
        System.out.println("数字:" + count);

        // Integer 基础功能 -> 赋值比较
        Integer integer_1 = new Integer(number);
        Integer integer_2 = number;
        Integer integer_3 = Integer.valueOf(number);

        System.out.println("1:" + (integer_1 == integer_2));
        // 相等条件 -128 ~ 127
        System.out.println("2:" + (integer_2 == integer_3));
        System.out.println("3:" + (integer_3 == number));
        System.out.println("4:" + (integer_2 == number));
    }
    
    
    /**
     * 构建多线程处理数据 -> 对 atomic线程做处理
     * int 和 Atomic 线程安全测试
     * @throws ExecutionException
     * @throws InterruptedException
     * 
     * ! 结果
     * 线程有问题数据:94010
     * 线程没有有问题数据:101066
     * 求和 101066
     */
    public void executorInt() throws ExecutionException, InterruptedException {
        final IntNumberVo intNumberVo = new IntNumberVo();
        List<List<Integer>> list = InstanceUtil.groupByNumber(
            InstanceUtil.getRandomNumber(100, 1000), 5);
        
        int numberSum = 0;
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (final List<Integer> temp : list) {
            executorService.execute(new Runnable() {
                public void run() {
                    for (Integer integer : temp) {
                        try {
                            Thread.sleep(2L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        intNumberVo.intAdd(integer);
                        intNumberVo.intAtomicIntege(integer);
                    }
                }
            });

            executorService.execute(new Runnable() {
                public void run() {
                    int i = 0;
                    for (Integer integer : temp) {
                        try {
                            Thread.sleep(3L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        intNumberVo.intAdd(integer);
                        intNumberVo.intAtomicIntege(integer);
                        System.out.println("次数:" + i++);
                    }
                }
            });
        }

        executorService.shutdown();
        while(true){
            if(executorService.isTerminated()){
                System.out.println("所有的子线程都结束了！");
                break;
            }
            Thread.sleep(1000);
        }
        System.out.println("线程有问题数据:" + intNumberVo.getBaseInt());
        System.out.println("线程没有有问题数据:" + intNumberVo.getAtomictInteger());
        
        int sum = 0;
        for (List<Integer> one : list) {
            for (Integer two : one) {
                sum += two;
            }
        }
        System.out.println("求和 " + (sum + 1000));
        System.out.println("求和 " + (sum * 2 + 1000));
    }
    
    public static void main(String[] args) throws Exception {
//        IntToIntegerService intToIntegerService = new IntToIntegerService();
//        intToIntegerService.executorInt();
//        System.out.println("finish");
        
        int temp = 5;
        if (temp == 5) 
            throw new Exception();
        System.out.println("finish");
    }
}
