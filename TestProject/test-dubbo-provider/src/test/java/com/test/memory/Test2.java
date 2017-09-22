package com.test.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bjyushicong on 2017/9/19.
 */
public class Test2 {

    //-XX:PermSize=10m -XX:MaxPermSize=10m
    //常量池溢出（1.8以后不在方法区中）
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }

}
