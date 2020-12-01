package deadwood;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DeadwoodLogger extends AbstractLogger {
    private final static Logger logger = Logger.getLogger(AbstractLogger.class.getName());

    public static void logWarning(String message) {
        logger.log(Level.WARNING, message);
    }

    public static void logInfo(String message) {
        logger.log(Level.INFO, message);
    }
}
