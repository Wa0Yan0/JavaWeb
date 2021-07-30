package com.example.utils;


import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    /**
     * @function 将Map集合赋值给对象
     * @param map
     * @param bean
     * @param <T>
     * @return bean 带有参数的实例化对象
     */
    public static <T> T copyParamToBean(T bean, Map map){
        try {
            BeanUtils.populate(bean,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int getInt(String strInt, int defaultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
            System.out.println("strInt未获得值，使用默认值");
        }
        return defaultValue;

    }
}
