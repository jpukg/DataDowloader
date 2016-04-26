package launchers;


import config.MyConfig;
import extractors.URLConnector;
import extractors.XMLDownloader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        XMLDownloader dwl = context.getBean(XMLDownloader.class);
        URLConnector con = context.getBean(URLConnector.class);
        dwl.download(con);
    }
}
