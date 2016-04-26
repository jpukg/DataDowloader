package extractors;

import java.io.*;

public abstract class FileDownloader {

    public void download(Connector connector) {
        try (BufferedInputStream inp = new BufferedInputStream(connector.getInputStream());
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(targetFile()))) {
            int data = inp.read();
            while (data > -1) {
                out.write(data);
                data = inp.read();
            }
            out.flush();
        } catch (IOException e) {
            throw new IncorrectSourceException("Can't download file.", e);
        }
    }

    protected abstract File targetFile();
}
