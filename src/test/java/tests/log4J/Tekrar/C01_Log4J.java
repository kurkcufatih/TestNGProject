package tests.log4J.Tekrar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import tests.log4J.Log4JTest1;

public class C01_Log4J {
    private static Logger logger = LogManager.getLogger(C01_Log4J.class.getName());

    @Test
    public void Log4JTest1() {
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
