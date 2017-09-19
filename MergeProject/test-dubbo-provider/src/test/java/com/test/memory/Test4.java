package com.test.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bjyushicong on 2017/9/19.
 */
public class Test4 {
    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    //-Xss64k
    //栈空间溢出 栈帧不够大(也就是深度过深)（栈帧在栈空间内）（也就是栈空间不足）
    public static void main(String[] args) {
        try {
            Test4 test = new Test4();
            test.stackLeak();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
