package com.ysc.bug;

import com.ysc.kafka.producer.KafkaProductorService;
import com.ysc.util.ApplicationContextHelper;
import com.ysc.util.PropertiesUtils;
import org.springframework.context.ApplicationContext;
import java.util.Properties;

/**
 * Created by bjyushicong on 2017/9/27.
 */
public class KafkaException {
    private Properties prop = PropertiesUtils.loadProperties("/system_param.properties");

    public String open = "1";

    public void outOfCapacity(){
        String flag = prop.getProperty("kafka.outOfCapacity");
        if(flag.equals(open)){
            while (true){
                Thread thread = new Thread(new Runnable() {
                    public void run() {
                        ApplicationContext apptx = ApplicationContextHelper.getContext();
                        KafkaProductorService ks = (KafkaProductorService) apptx.getBean("kafkaProductorService");
                        StringBuffer msg = new StringBuffer("start");
                        for (int i = 0; i < 100000000; i++) {
                            msg.append("qwertyuiop[asdfghjkl;111111111111111111111111111111111111");
                        }
                        ks.sendInfo("test",msg);
                    }
                });
                thread.start();
            }
        }
    }
}
