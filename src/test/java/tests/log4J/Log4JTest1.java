package tests.log4J;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.MarkerManager;
import org.testng.annotations.Test;

public class Log4JTest1 {
    private static Logger logger = LogManager.getLogger(Log4JTest1.class.getName());

@Test
    public void Log4jTest1(){
    logger.info("LOG INFO");
    logger.debug("LOG DEBUG");
    logger.error("LOG ERROR");
    logger.fatal("LOG FATAL");
}
/*LOG4J
Genel olarak Log4J yi debug
Fatal logs = ölümcül hatalar applicationlarda kesinlikle olmaz
Error logs = olma ihtimali var, mesela button orada kayboldu diyelim, exception geldi, hatayi yazdirabiliriz
Informational logs =
Debug logs = diyelimki hata aldınız hangi sayfada hangi satırda olmuş bu hatayı bulma durumu.
 */

}
