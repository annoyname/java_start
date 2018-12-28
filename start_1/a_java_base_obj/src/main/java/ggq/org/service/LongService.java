package ggq.org.service;

/**
 * @author ggq Date: 2018-12-28 Time: 15:49
 * @version $Id$
 */
public class LongService {

    // int long 和 对象 Integer Long 之间的转化
    public void longChange() throws Exception {
        int number_int = Integer.MAX_VALUE;
        long number_long = Integer.MAX_VALUE;
        
        Integer number_Integer = Integer.MAX_VALUE;
        Long number_Long = Long.valueOf(Integer.MAX_VALUE);

        // 模型转化 int -> long
        long temp_long_int = number_int;
        System.out.println("int -> long:" + temp_long_int + ", " + 
                               (temp_long_int == number_int ? "true" : "false"));
        
        // long -> int
        if  (number_long > Integer.MAX_VALUE) {
            throw new Exception("数据过大不能转化成int类型");
        }
        int temp_int_long = Integer.valueOf(String.valueOf(number_long));
        System.out.println("long -> int:" + temp_int_long + ", " +
                               (temp_int_long == number_long ? "true" : "false"));
        
        // int -> Integer 和 long -> Long
        System.out.println("int -> Integer:" + new Integer(number_int));
        System.out.println("long -> Long:" + new Long(number_long));
        
        // Integer -> long
        long temp_long_Integer = number_Integer.longValue();
        System.out.println("Integer -> long:" + temp_long_Integer + ", " + 
                               (temp_long_Integer == number_Integer ? "true" : "false"));
        
        // long -> Integer
        if  (number_long > Integer.MAX_VALUE) {
            throw new Exception("数据过大不能转化成Integer类型");
        }
        Integer temp_Integer_long = Integer.valueOf(String.valueOf(number_long));
        System.out.println("long -> Integer:" + temp_Integer_long + ", " + 
                               (temp_Integer_long == number_long ? "true" : "false"));
        
    }
    
    public static void main(String[] args) throws Exception {
        try {
            LongService longService = new LongService();
            longService.longChange();
            System.out.println("finish");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
      
    }

}
