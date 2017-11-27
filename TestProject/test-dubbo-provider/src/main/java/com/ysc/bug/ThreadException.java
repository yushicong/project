package com.ysc.bug;

import com.ysc.util.PropertiesUtils;

import java.util.Properties;

/**
 * Created by bjyushicong on 2017/11/27.
 */
public class ThreadException {
    private Properties prop = PropertiesUtils.loadProperties("/system_param.properties");
    public String open = "1";
    public  void deadLock() throws InterruptedException {
        String flag = prop.getProperty("thread.deadLock");
        if(flag.equals(open)) {
            Object obj1 = new Object();
            Object obj2 = new Object();
            Object obj3 = new Object();

            Thread t1 = new Thread(new SyncThread(obj1, obj2), "t1");
            Thread t2 = new Thread(new SyncThread(obj2, obj3), "t2");
            Thread t3 = new Thread(new SyncThread(obj3, obj1), "t3");

            t1.start();
            Thread.sleep(5000);
            t2.start();
            Thread.sleep(5000);
            t3.start();
        }

    }
}

class SyncThread implements Runnable{
    private Object obj1;
    private Object obj2;

    public SyncThread(Object o1, Object o2){
        this.obj1=o1;
        this.obj2=o2;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " acquiring lock on "+obj1);
        synchronized (obj1) {
            System.out.println(name + " acquired lock on "+obj1);
            work();
            System.out.println(name + " acquiring lock on "+obj2);
            synchronized (obj2) {
                System.out.println(name + " acquired lock on "+obj2);
                work();
            }
            System.out.println(name + " released lock on "+obj2);
        }
        System.out.println(name + " released lock on "+obj1);
        System.out.println(name + " finished execution.");
    }
    private void work() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
