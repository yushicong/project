package com.test.memory;

/**
 * Created by bjyushicong on 2017/9/19.
 */
public class Test3 {
    private void dontStop(){
        while (true){}
    }

    public void stackLwakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }
    //-Xss2M
    // 栈空间不够用
    public static void main(String[] args) {
        Test3 test = new Test3();
        test.stackLwakByThread();
    }
}
