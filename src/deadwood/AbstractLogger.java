package deadwood;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public abstract class AbstractLogger {
    private final static Logger LOGGER = Logger.getLogger(AbstractLogger.class.getName());
    private static FileHandler fh;

    public static void init() {
        try {
            fh = new FileHandler("deadwood.log", false);
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
        Logger l = Logger.getLogger("");
        fh.setFormatter(new SimpleFormatter());
        l.addHandler(fh);
        l.setLevel(Level.CONFIG);
    }
}

