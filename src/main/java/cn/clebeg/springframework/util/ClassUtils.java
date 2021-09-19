package cn.clebeg.springframework.util;

import cn.hutool.core.util.ClassLoaderUtil;

/**
 * @author clebegxie
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {

        return ClassLoaderUtil.getContextClassLoader();
    }
}
