package extractors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class XMLDownloader extends FileDownloader {

    @Value("${xml.repository}")
    private String path;

    protected File targetFile() {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmm");
        String name = ldt.format(formatter);
        String fullName = path + name + ".xml";
        return new File(fullName);
    }

    @Override
    public String toString() {
        return "URLDownloader{" +
                "path='" + path + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XMLDownloader that = (XMLDownloader) o;

        return !(path != null ? !path.equals(that.path) : that.path != null);

    }

    @Override
    public int hashCode() {
        return path != null ? path.hashCode() : 0;
    }
}
