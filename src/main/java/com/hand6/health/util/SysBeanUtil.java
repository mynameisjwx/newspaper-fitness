//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hand6.health.util;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;

public class SysBeanUtil extends BeanUtils {
    public SysBeanUtil() {
    }

    public static String[] getNullPropertyNames(Object source) {
        BeanWrapperImpl src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        HashSet emptyNames = new HashSet();
        PropertyDescriptor[] result = pds;
        int var5 = pds.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            PropertyDescriptor pd = result[var6];
            Object srcValue = src.getPropertyValue(pd.getName());
            if(srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }

        String[] var9 = new String[emptyNames.size()];
        return (String[])emptyNames.toArray(var9);
    }

    public static void copyPropertiesIgnoreNull(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    public static void copyPropertiesIgnoreNull(Object src, Object target, String... ignoreProperties) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }
}
