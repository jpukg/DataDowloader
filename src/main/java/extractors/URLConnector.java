package extractors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class URLConnector implements Connector {

    private InputStream inp;

    @Autowired
    public URLConnector(@Value("${xml.source}") String xmlSrc) throws IOException {
        inp = new URL(xmlSrc).openStream();
    }

    public InputStream getInputStream() {
        return inp;
    }

    @Override
    public void close() throws Exception {
        inp.close();
    }

    @Override
    public String toString() {
        return "URLConnector{" +
                "inp=" + inp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        URLConnector that = (URLConnector) o;

        return !(inp != null ? !inp.equals(that.inp) : that.inp != null);

    }

    @Override
    public int hashCode() {
        return inp != null ? inp.hashCode() : 0;
    }
}
