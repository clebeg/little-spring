package cn.clebeg.springframework.core.io;

/**
 * @author clebegxie
 */
public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 获取资源文件，通过 location
     * @param location resource location
     * @return resource
     */
    Resource getResource(String location);
}
