package qa.guru;

import java.io.InputStream;
import java.util.zip.ZipInputStream;


public interface StreamMethod {
    public static InputStream getStream(String resource){
        ClassLoader cl = StreamMethod.class.getClassLoader();
        InputStream s = cl.getResourceAsStream(resource);
        return s;
    }
}
