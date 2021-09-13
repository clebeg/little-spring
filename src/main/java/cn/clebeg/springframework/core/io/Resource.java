package cn.clebeg.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resource 读取 spring 配置的顶层接口。
 * @author clebegxie
 */
public interface Resource {

    /**
     * 获取资源文件的输入流。
     * @return 资源文件的输入流
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;
}
