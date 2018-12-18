package ggq.org.vo;

import java.io.Serializable;

/**
 * 基础类型定义
 * @author ggq Date: 2018-12-17 Time: 21:14
 * @version $Id$
 */
public class PersonVo implements Serializable {

    // 2 字节
    private char[] descHair;
    
    // int 32 位 4 字节  -2^31——2^31-1，即-2147483648——2147483647
    private int eyeNumber;
    
    // long 64位 8字节 -2^64 - 2^64 -1 -9223372036854774808~9223372036854774807
    private long handNumber;
    
    // 1字节
    private boolean isGirl;
    
    // -2^7 ~ 2^7 默认值 0
    private byte del;
    
    // 2 字节 16位
    private short footNumber;
    
    // 4 字节
    private float year;
    
    // 8字节 双精度、64位
    private double money;

    public char[] getDescHair() {
        return descHair;
    }

    public void setDescHair(char[] descHair) {
        this.descHair = descHair;
    }

    public int getEyeNumber() {
        return eyeNumber;
    }

    public void setEyeNumber(int eyeNumber) {
        this.eyeNumber = eyeNumber;
    }

    public long getHandNumber() {
        return handNumber;
    }

    public void setHandNumber(long handNumber) {
        this.handNumber = handNumber;
    }

    public boolean isGirl() {
        return isGirl;
    }

    public void setGirl(boolean girl) {
        isGirl = girl;
    }

    public byte getDel() {
        return del;
    }

    public void setDel(byte del) {
        this.del = del;
    }

    public short getFootNumber() {
        return footNumber;
    }

    public void setFootNumber(short footNumber) {
        this.footNumber = footNumber;
    }

    public float getYear() {
        return year;
    }

    public void setYear(float year) {
        this.year = year;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
