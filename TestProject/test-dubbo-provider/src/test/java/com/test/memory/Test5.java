package com.test.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bjyushicong on 2017/9/19.
 */
public class Test5 {
    static class OOMObject{

    }
    // -Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError
    // 堆溢出
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
    }

}
