package log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo {
    private static final Logger log = LogManager.getLogger(Demo.class);

    public static void main(String[] args) {
        log.debug("I am debugging");
        log.info("object is present");
        log.error("button is not displayed");
        log.fatal("button is missing");


    }
}
