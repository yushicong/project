package com.ysc.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @version : estimate
 * @Enclosing_Method : com.youku.estimate.util
 * @Written by : yushicong
 * @Creation Date : 2016/3/16 15:11
 * @Description : 获得ApplicationContext
 */
public class ApplicationContextHelper implements ApplicationContextAware {
    private static ApplicationContext context;

    public void setApplicationContext(ApplicationContext contex) throws BeansException {
        ApplicationContextHelper.context = contex;
    }

    public static ApplicationContext getContext()
    {
        return context;
    }

}