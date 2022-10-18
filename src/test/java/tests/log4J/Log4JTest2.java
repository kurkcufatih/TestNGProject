package tests.log4J;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Log4JTest2 {

    private static Logger logger = LogManager.getLogger(Log4JTest2.class.getName());
    @Test
    public void log4jTest1(){
      //info : bilgi vermek icin kullanilir
        System.out.print("log info");
        logger.info("LOG INFO");
        System.out.print("log debug hatasi ");
        logger.debug("LOG DEBUG");
        System.out.print("log debug hatasi ");
        logger.error("LOG ERROR");
        System.out.print("log debug hatasi ");
        logger.fatal("LOG FATAL");
        System.out.print("log debug hatasi ");
        logger.warn("LOG WARN");
    }

}