package cn.clebeg.springframework.utils;

import cn.hutool.core.util.ClassLoaderUtil;

/**
 * @author clebegxie
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {

        return ClassLoaderUtil.getContextClassLoader();
    }
}
