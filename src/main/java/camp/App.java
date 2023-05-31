package camp;

import camp.configuration.AppConfiguration;
import camp.core.Core;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext box = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Core core = box.getBean(Core.class);
        core.start();
    }
}
