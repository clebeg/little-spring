package cn.clebeg.springframework.core.io;

import cn.clebeg.springframework.util.ClassUtils;
import cn.hutool.core.lang.Assert;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author clebegxie
 */
public class ClassPathResource implements Resource {
    private final String path;
    private final ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");

        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (null == is) {
            throw new FileNotFoundException(
                    this.path + " cannot be opened because it dose not exist"
            );
        }
        return is;
    }
}
