package com.ysc.bug;


import com.alibaba.druid.pool.DruidDataSource;
import com.ysc.dao.UserMapper;
import com.ysc.kafka.producer.KafkaProductorService;
import com.ysc.model.User;
import com.ysc.util.ApplicationContextHelper;
import com.ysc.util.PropertiesUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;


/**
 * Created by bjyushicong on 2017/9/25.
 */
public class MysqlException {

    private Properties prop = PropertiesUtils.loadProperties("/system_param.properties");

    private Properties propdb = PropertiesUtils.loadProperties("/dbconfig.properties");

    public String open = "1";
    

    public void outOfConnection() throws Exception{
        String flag = prop.getProperty("mysql.outOfConnection");
        if(flag.equals(open)) {
            while (true) {
                Thread thread = new Thread(new Runnable() {
                    public void run() {
                        DriverManagerDataSource ds = new DriverManagerDataSource ();
                        ds.setDriverClassName(propdb.getProperty("druid.driverClassName"));
                        ds.setUrl(propdb.getProperty("druid.url"));
                        ds.setUsername(propdb.getProperty("druid.username"));
                        ds.setPassword(propdb.getProperty("druid.password"));
                        try {
                            Connection actualCon = ds.getConnection();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        }
    }

    public void slowQuery() throws SQLException {
        String flag = prop.getProperty("mysql.slowQuery");
        if(flag.equals(open)) {
            DriverManagerDataSource ds = new DriverManagerDataSource ();
            ds.setDriverClassName(propdb.getProperty("druid.driverClassName"));
            ds.setUrl(propdb.getProperty("druid.url"));
            ds.setUsername(propdb.getProperty("druid.username"));
            ds.setPassword(propdb.getProperty("druid.password"));
            Connection actualCon = ds.getConnection();
            Statement st = actualCon.createStatement();
            st.executeQuery("SELECT SLEEP(20)");
            st.close();
            actualCon.close();
        }
    }

    public void deadLock() throws SQLException {
        String flag = prop.getProperty("mysql.deadLock");
        if(flag.equals(open)) {
            DriverManagerDataSource ds = new DriverManagerDataSource ();
            ds.setDriverClassName(propdb.getProperty("druid.driverClassName"));
            ds.setUrl(propdb.getProperty("druid.url"));
            ds.setUsername(propdb.getProperty("druid.username"));
            ds.setPassword(propdb.getProperty("druid.password"));
            Connection actualCon = ds.getConnection();
            Statement st = actualCon.createStatement();
            st.execute("select * from help_category where id in (8,9) for update;");
            st.execute("select * from help_category where id in (10,8,5) for update;");
            st.close();
            actualCon.close();
        }
    }

}
