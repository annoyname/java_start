package ggq.org.vo;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 用于计算的vo
 * @author ggq Date: 2018-12-18 Time: 16:28
 * @version $Id$
 */
public class IntNumberVo implements Serializable {

    private volatile AtomicInteger atomictInteger = new AtomicInteger(1000);
    
    private volatile int baseInt = 1000;

    // 对 数据进行处理 -> 支持多线程
    public void intAtomicIntege(int addNumber) {
        atomictInteger.addAndGet(addNumber);
        System.out.println(Thread.currentThread().getName() + " 支持多线程处理数据 atomic:" + atomictInteger.get() + ", number:" + addNumber);
    }


    // 对 数据进行处理 -> 不支持多线程
    public void intAdd(int addNumber) {
        baseInt += addNumber;
        System.out.println(Thread.currentThread().getName() + " 不支持多线程处理数据 baseInt:" + baseInt + ", number:" + addNumber);
    }

    public AtomicInteger getAtomictInteger() {
        return atomictInteger;
    }

    public int getBaseInt() {
        return baseInt;
    }
}
