package com.ysc.util;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * <b>类描述：</b>读取properties文件的帮助类<br/>  
 * <b>@author </b>yushicong<br/>  
 * <b>修改时间：</b>Jul 20, 2012 3:48:36 PM<br/> 
 * <b>修改备注：</b><br/> 
 *
 */
public class PropertiesUtils {
	private static final Logger logger = Logger.getLogger(PropertiesUtils.class);
	private static Map<String, Properties> propertiesMap = new HashMap<String, Properties>();
	public static String getProperties(String path, String proName){
		Properties properties = propertiesMap.get(path);
		String value = "";
		if(null == properties){
			properties = loadProperties(path);
		}
		if(properties != null){
			value = properties.getProperty(proName);
		}else {
			logger.warn("properties is 'null' .");
		}
		return value;
	}
	public static Properties loadProperties(String path){
		logger.debug("=====read properties file =====");
		InputStream input = null;
		Properties properties;
		try{
			input = PropertiesUtils.class.getResourceAsStream(path);
			properties = new Properties();
			properties.load(input);
			propertiesMap.put(path, properties);
		}catch(Exception ex){
			logger.error("[ get properties ] ", ex);
			properties = null;
		}finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.error("[ get properties ] ", e);
				} finally {
					input = null;
				}
			}
		}
		return properties;
	}
	public static void setProperties(String path,String proName,String value){
		Properties properties = propertiesMap.get(path);
		if(null == properties){
			properties = loadProperties(path);
		}
		if(properties != null){
			OutputStream out = null;
			try{
				URL urlPath = SystemProperties.class.getResource(path);
				File file = new File(urlPath.toURI());
				out = new FileOutputStream(file);
				properties.setProperty(proName, value);
				properties.store(out,"proName");
				out.flush();
			}catch(Exception ex){
				logger.error("[ set properties ] ", ex);
				properties = null;
			}
			finally{
				if (null != out){
					try {
						out.close();
					} catch (IOException e) {
						logger.error("[ set properties ] ", e);
					} finally {
						out = null;
					}
				}
			}
		}
		
	}

}
