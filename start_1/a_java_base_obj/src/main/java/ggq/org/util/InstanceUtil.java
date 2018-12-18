package ggq.org.util;

import com.google.common.collect.Lists;
import ggq.org.vo.PersonVo;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import sun.text.CollatorUtilities;

/**
 * 实例化工具类
 * @author ggq Date: 2018-12-17 Time: 21:21
 * @version $Id$
 */
public class InstanceUtil {

    /**
     * Person实例化
     * @return 获得person对象
     */
    public static PersonVo getPersonInstance() {
        PersonVo personVo = new PersonVo();
        personVo.setDescHair("yellow".toCharArray());
        personVo.setDel((byte) 0);
        
        personVo.setEyeNumber((int) (Math.random() * 2));
        personVo.setFootNumber((short) (Math.random() * 10));
        personVo.setGirl(false);
        
        personVo.setHandNumber((long) (Math.random() * 10));
        personVo.setYear((float) (Math.random() * 50));
        personVo.setMoney(Math.random() * 10000);
        
        return personVo;
    }

    /**
     * 构建随机数组
     * @param maxNumber 最大值
     * @param needNumber 数据量
     * @return
     */
    public static List<Integer> getRandomNumber(int maxNumber, int needNumber) {
        List<Integer> lists = Lists.newArrayList();
        if (needNumber < 0) {
            return lists;
        }
        
        for (int i = 0; i < needNumber; i++) {
            lists.add((int) (Math.random() * maxNumber));
        }
        
        return lists;
    }

    /**
     * 对数据分组
     * @param list 数据
     * @param groupNum 分成的组数
     * @param <T> 泛型
     * @return 分成对应的组
     */
    public static <T> List<List<T>> groupByNumber(List<T> list, Integer groupNum) {
        List<List<T>> reList = new ArrayList<List<T>>();
        if (CollectionUtils.isEmpty(list) || groupNum <= 0) {
            reList.add(list);
            return reList;
        }

        if (list.size() > groupNum) {
            int size = list.size();
            int commonNum = size % groupNum == 0 ? size / groupNum : size / groupNum + 1;
            for (int i = 0; i < groupNum; i++) {
                reList.add(list.subList(i * commonNum, (i + 1) * commonNum < size ? (i + 1) * commonNum : size));
            }
        } else {
            reList.add(list);
        }
        return reList;
    }
}
