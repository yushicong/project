package com.test.memory;

/**
 * Created by bjyushicong on 2017/9/19.
 */
import sun.misc.Unsafe;

import java.lang.reflect.Field;

// 直接内存 抛OutOfMemoryError异常
// -XX:MaxDirectMemorySize=10M

public class Test1 {

    private static final int _1MB = 1024*1024;
    public static void main(final String[] args) throws  Exception{
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }
    }

}