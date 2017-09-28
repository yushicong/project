package com.ysc.bug;

import com.ysc.util.PropertiesUtils;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodProxy;
import sun.misc.Unsafe;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by bjyushicong on 2017/9/25.
 */
public class JVMmemory {

    private Properties prop = PropertiesUtils.loadProperties("/system_param.properties");

    public String open = "1";

    private static final int _1MB = 1024*1024;

    static class OOMObject{

    }

    class Bug {
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
    }

    class Bug2 {
        private int stackLength = 1;

        public void stackLeak(){
            stackLength++;
            stackLeak();
        }

    }

    /**
     * 直接内存 溢出
     * 由DirectMemory导致的内存溢出，一个明显的特点是在Heap Dump文件中不会看见明显的异常，dump文件很小，而程序又直接或间接的使用了NIO，就有可能是这个方面的原因
     * @throws IllegalAccessException
     */
    public void directMemory() throws IllegalAccessException {
        String flag = prop.getProperty("jvm.directMemory");
        if(flag.equals(open)){
            Field unsafeField = Unsafe.class.getDeclaredFields()[0];
            unsafeField.setAccessible(true);
            Unsafe unsafe = (Unsafe) unsafeField.get(null);
            while (true){
                unsafe.allocateMemory(_1MB * 100);
            }
        }
    }

    /**
     * 常量池溢出（类加载过多-动态加载class）
     * 借助CGLib使方法区出现内存溢出异常
     */
    public void funcMemory(){
        String flag = prop.getProperty("jvm.funcMemory");
        if(flag.equals(open)){
            while (true){
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMObject.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(objects,null);
                    }
                });
                enhancer.create();
            }
        }
    }

    /**
     * 栈空间 溢出 (广度)
     */
    public void stackBreathMemory(){
        String flag = prop.getProperty("jvm.stackBreathMemory");
        if(flag.equals(open)){
            Bug bug = new Bug();
            bug.stackLwakByThread();
        }
    }

    /**
     * 栈空间 溢出 (深度)
     */
    public void stackDepthMemory(){
        String flag = prop.getProperty("jvm.stackDepthMemory");
        if(flag.equals(open)){
            Bug2 bug2 = new Bug2();
            bug2.stackLeak();
        }
    }

    /**
     * 堆溢出
     */
    public void heap(){
        String flag = prop.getProperty("jvm.heap");
        if(flag.equals(open)){
            List<OOMObject> list = new ArrayList<OOMObject>();
            while (true){
                list.add(new OOMObject());
            }
        }
    }
}
