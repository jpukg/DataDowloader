package extractors;


import java.io.InputStream;

public interface Connector extends AutoCloseable {

    public InputStream getInputStream();
}
